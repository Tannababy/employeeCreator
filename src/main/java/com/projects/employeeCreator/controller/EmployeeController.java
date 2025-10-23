package com.projects.employeeCreator.controller;

import com.projects.employeeCreator.dto.EmployeeDTO;
import com.projects.employeeCreator.model.Employee;
import com.projects.employeeCreator.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
