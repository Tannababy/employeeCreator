package com.projects.employeeCreator.service;

import com.projects.employeeCreator.dto.EmployeeDTO;
import com.projects.employeeCreator.model.Employee;
import com.projects.employeeCreator.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    public final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();

        for (Employee emp : employees) {
            EmployeeDTO newDTO = new EmployeeDTO(
                    emp.getId().toString(),
                    emp.getFirstName(),
                    emp.getLastName(),
                    emp.getEmail(),
                    emp.getDepartment()
            );

            employeeDTOs.add(newDTO);
        }
        return employeeDTOs;
    }

}
