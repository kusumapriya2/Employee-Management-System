package net.javaguides.springboot.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.EmployeeService;
import net.javaguides.springboot.service.UserService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

    // Home page (login/signup)
    @GetMapping("/")
    public String homePage() {
        return "home";  // Points to the home.html (where login and signup options can be)
    }

    // Show the employee list after successful login
    @GetMapping("/employees")
    public String viewEmployeesPage(Model model, HttpSession session) {
        // Check if the user is logged in
        if (session.getAttribute("user") == null) {
            return "redirect:/login"; // Redirect to login if not authenticated
        }
        return findPaginated(1, "name", "asc", model); // Return employee list with pagination
    }

    // Pagination method for employees
    private String findPaginated(int pageNo, String sortField, String sortDir, Model model) {
        int pageSize = 5;  // Page size for pagination
        Page<Employee> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
        model.addAttribute("listEmployees", page.getContent());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        return "employee_list";  // Return to the employee_list.html page
    }

    // Display the Add Employee form
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";  // Redirect to login if not authenticated
        }
        Employee employee = new Employee();  // Create a new employee object for the form
        model.addAttribute("employee", employee);  // Add the employee object to the model
        return "new_employee";  // Return the new_employee.html form
    }

    // Save the new employee after form submission
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);  // Save the employee via the service
        return "redirect:/employees";  // Redirect back to the employee list page
    }

    // Display the Update Employee form
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);  // Fetch employee by id
        model.addAttribute("employee", employee);  // Add employee to the model
        return "update_employee";  // Return the update_employee.html form
    }

    // Update employee details after form submission
    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.updateEmployee(employee);  // Update the employee via the service
        return "redirect:/employees";  // Redirect back to the employee list page
    }

    // Delete an employee
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        employeeService.deleteEmployeeById(id);  // Delete employee by id via the service
        return "redirect:/employees";  // Redirect back to the employee list page
    }

    // Login page
    @GetMapping("/login")
    public String login() {
        return "login";  // Return the login.html page
    }

    // Handle login submission
    @PostMapping("/login")
    public String authenticate(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        Optional<User> user = userService.authenticateUser(username, password);  // Authenticate the user
        if (user != null) {
            session.setAttribute("user", user);  // Store the user in the session
            return "redirect:/employees";  // Redirect to employee list page after successful login
        } else {
            model.addAttribute("error", "Invalid username or password.");  // Show error message if login fails
            return "login";  // Stay on the login page if authentication fails
        }
    }

    // Registration page
    @GetMapping("/register")
    public String register() {
        return "register";  // Return the register.html page
    }

    // Handle registration submission
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        if (userService.registerUser(user) != null) {
            model.addAttribute("message", "Registration successful! Please log in.");  // Show success message
            return "redirect:/login";  // Redirect to login page after successful registration
        } else {
            model.addAttribute("error", "Registration failed.");  // Show error message if registration fails
            return "register";  // Stay on the registration page if registration fails
        }
    }
}
