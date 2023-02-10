package com.example.employeemanagementsystem.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.DeleteMapping;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("employee-mngmt-system")
public class EmployeeEntity
{
    @Id
    private String employeeId;
    private String firstName;
    private String lastName;
    private String employeeEmail;
    private double salary;
    private String role;
    private String managerId;
}
