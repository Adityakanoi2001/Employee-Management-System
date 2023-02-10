package com.example.employeemanagementsystem.Dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInputDto
{
    private String firstName;
    private String lastName;
    private String employeeEmail;
    private double salary;
    private String role;
    private String managerId;
}
