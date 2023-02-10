package com.example.employeemanagementsystem.Controller;


import com.example.employeemanagementsystem.Dtos.ManagerInputDto;
import com.example.employeemanagementsystem.Entities.EmployeeEntity;
import com.example.employeemanagementsystem.Entities.ManagerEntity;
import com.example.employeemanagementsystem.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/manager")
@RestController
public class ManagerController
{

    @Autowired
    ManagerService managerService;

    @PostMapping("/saveDetails")
    public ResponseEntity<String> saveManagerDetails (@RequestBody ManagerInputDto managerInputDto)
    {
        return new ResponseEntity(managerService.saveManagerDetails(managerInputDto),HttpStatus.CREATED);
    }

    @GetMapping("/getManagerDetails/{managerId}")
    public ResponseEntity<ManagerEntity> getManagerDetails (@PathVariable String managerId)
    {
        return new ResponseEntity(managerService.findManagerById(managerId),HttpStatus.OK);
    }

    @DeleteMapping("/deleteManagerDetails/{managerId}")
    public ResponseEntity<String> deleteManagerDetails(@PathVariable String managerId)
    {
        return new ResponseEntity(managerService.deleteManagerById(managerId),HttpStatus.OK);
    }

    @GetMapping("/getAllManagers")
    public ResponseEntity<List<ManagerEntity>> getAllManagerDetails()
    {
        return new ResponseEntity(managerService.findAllManager(),HttpStatus.OK);
    }

    @GetMapping("/getAllManagerUnderSuperManager/{managerId}")
    public ResponseEntity<List<ManagerEntity>> getAllManagerUnderSuperManager(String managerId)
    {
        return new ResponseEntity(managerService.allManagerUnderSuperiorManager(managerId),HttpStatus.OK);
    }

    @GetMapping("/getAboveManager")
    public ResponseEntity<List<ManagerEntity>> getAboveManager(String managerId)
    {
        return new ResponseEntity(managerService.getAboveManager(managerId),HttpStatus.OK);
    }

}
