package com.example.employeemanagementsystem.Dtos;

import lombok.Data;

@Data
public class ManagerInputDto
{
    private String firstName;
    private String lastName;
    private double salary;
    private String email;
    private String parentId;
}
