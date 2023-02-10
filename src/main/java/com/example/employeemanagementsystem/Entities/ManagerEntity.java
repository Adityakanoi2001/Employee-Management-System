package com.example.employeemanagementsystem.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("manager")
public class ManagerEntity
{
    @Id
    private String managerId;
    private String firstName;
    private String lastName;
    private double salary;
    private String email;
    private String parentId;

}
