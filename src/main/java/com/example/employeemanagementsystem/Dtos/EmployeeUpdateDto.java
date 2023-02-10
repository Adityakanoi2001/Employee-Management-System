package com.example.employeemanagementsystem.Dtos;


import lombok.Data;

@Data
public class EmployeeUpdateDto {

    private String employeeId;
    private String employeeEmail;
    private double salary;
    private String role;
    private String managerId;
}
