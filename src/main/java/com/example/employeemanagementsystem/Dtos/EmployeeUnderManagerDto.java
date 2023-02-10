package com.example.employeemanagementsystem.Dtos;

import com.example.employeemanagementsystem.Entities.EmployeeEntity;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeUnderManagerDto
{
    private List<EmployeeEntity> employeeEntityList;
    int numberofemployee;
}
