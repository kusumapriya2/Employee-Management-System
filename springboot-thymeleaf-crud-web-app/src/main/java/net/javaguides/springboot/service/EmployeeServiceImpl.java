package net.javaguides.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Method to save employee
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    // Method to get employee by ID
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // Method to delete employee by ID
    public void deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);
    }

    // Method to get paginated employees
    public Page<Employee> findPaginated(PageRequest pageRequest) {
        return employeeRepository.findAll(pageRequest); // Fetch paginated list of employees
    }
}
