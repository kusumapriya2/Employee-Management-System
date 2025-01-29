package net.javaguides.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Method to fetch paginated employee data
    public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDir) {
        // Create pageable object with sorting and pagination
        Sort sort = sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        PageRequest pageRequest = PageRequest.of(pageNo - 1, pageSize, sort);

        // Return the paginated result
        return employeeRepository.findAll(pageRequest);
    }

    // Save an employee
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    // Fetch employee by ID
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // Delete employee by ID
    public void deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);
    }

	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}
}
