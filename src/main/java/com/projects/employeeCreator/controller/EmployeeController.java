package com.projects.employeeCreator.controller;

import com.projects.employeeCreator.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    // constructor
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Endpoint to create employee
    // Endpoint to getEmployeesById
    // Endpoint to getAllEmployees
    // Endpoint to updateEmployee
    // Endpoint to deleteEmployee
}
