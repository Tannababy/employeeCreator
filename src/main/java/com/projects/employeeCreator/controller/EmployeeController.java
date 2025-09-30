package com.projects.employeeCreator.controller;

import com.projects.employeeCreator.model.Employee;
import com.projects.employeeCreator.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

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
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
    // Endpoint to getEmployeesById
    // Endpoint to getAllEmployees
    // Endpoint to updateEmployee
    // Endpoint to deleteEmployee
}
