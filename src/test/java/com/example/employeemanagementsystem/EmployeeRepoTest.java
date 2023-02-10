package com.example.employeemanagementsystem;


import com.example.employeemanagementsystem.Dtos.EmployeeInputDto;
import com.example.employeemanagementsystem.Entities.EmployeeEntity;
import com.example.employeemanagementsystem.Repo.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EmployeeRepoTest {

     @Autowired
     EmployeeRepository employeeRepo;

     @Test
    void isEmployeeExsitsById()
     {
         EmployeeEntity employeeEntity = new EmployeeEntity("testid-1","TestFirstName1","TestLastName1","testmail@gmail.com",90000.0,"SE Intern","4a479dcc-87fc-4558-8dea-e73ca93a57c8");
         employeeRepo.save(employeeEntity);

         Optional<EmployeeEntity> actualResult = employeeRepo.findById(employeeEntity.getEmployeeId());
         assertThat(actualResult).isPresent();

     }

    @AfterEach
    void tearDown()
    {
        System.out.println("Tear Down ");
        employeeRepo.deleteById("testid-1");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Before The Test Execution");
    }
}
