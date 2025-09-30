package com.projects.employeeCreator.model;

import jakarta.persistence.*;

@Entity //tells Spring/JPA this class maps to a database table.
public class Employee {

    // ensures each employee gets a unique primary key automatically.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private int mobile;
    private String address;
    private String department;
    private ContractInfo contractInfo;

    // no arg constructor required for JPA
    public Employee() {
    }

    public Employee(Integer id, String firstName, String lastName, int mobile, String email, String address, String department, ContractInfo contractInfo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.department = department;
        this.contractInfo = contractInfo;
    }


}
