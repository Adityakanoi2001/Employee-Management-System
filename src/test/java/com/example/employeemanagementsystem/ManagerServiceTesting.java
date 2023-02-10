package com.example.employeemanagementsystem;


import com.example.employeemanagementsystem.Entities.ManagerEntity;
import com.example.employeemanagementsystem.Repo.ManagerRepo;
import com.example.employeemanagementsystem.Service.ManagerService;
import com.example.employeemanagementsystem.Service.ManagerServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ManagerServiceTesting
{


    @Autowired
    ManagerService managerService;

    @Mock
    ManagerRepo managerRepo;



    @Test
    void findAllManagerTest()
    {
        List<ManagerEntity> managerEntityListActual = managerService.findAllManager();
        assertThat(managerEntityListActual.size()).isNotZero();
   //assertThat(managerEntityListActual).isEqualTo(managerRepo.findAll());

    }


}
