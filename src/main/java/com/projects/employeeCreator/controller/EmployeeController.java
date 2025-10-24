package com.projects.employeeCreator.controller;

import com.projects.employeeCreator.dto.EmployeeDTO;
import com.projects.employeeCreator.model.Employee;
import com.projects.employeeCreator.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    // constructor
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Endpoint to create employee
    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        if (employeeService.employeeRepository.existsByEmail(employee.getEmail())) {
            String message = "Employee " + employee.getFirstName() +
                    " with email " + employee.getEmail() +
                    " already exists. Please enter a new email.";
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }
        employeeService.createEmployee(employee);

        String message = "Employee " + employee.getFirstName() +
                " with email " + employee.getEmail() +
                " created successfully.";

        return ResponseEntity.status(HttpStatus.CREATED).body(message);

    }

    // Endpoint to getAllEmployees
    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Endpoint to deleteEmployee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable int id){

        if (!employeeService.employeeRepository.existsById(id)) {

            return ResponseEntity.notFound().build();
        }

        employeeService.deleteEmployeeById(id);
        return  ResponseEntity.noContent().build();
    }

    // Endpoint to getEmployeesById
    // Endpoint to updateEmployee

}
