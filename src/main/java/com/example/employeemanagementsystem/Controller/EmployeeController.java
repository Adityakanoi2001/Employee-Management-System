package com.example.employeemanagementsystem.Controller;


import com.example.employeemanagementsystem.Dtos.EmployeeInputDto;
import com.example.employeemanagementsystem.Dtos.EmployeeUnderManagerDto;
import com.example.employeemanagementsystem.Entities.EmployeeEntity;
import com.example.employeemanagementsystem.Entities.ManagerEntity;
import com.example.employeemanagementsystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController
{
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/saveDetails")
    public ResponseEntity<String> saveEmployeeDetails (@RequestBody EmployeeInputDto employeeInputDto)
    {
        return new ResponseEntity(employeeService.saveEmployeeDetails(employeeInputDto),HttpStatus.CREATED);
    }

    @GetMapping("/getEmployeeDetails/{employeeId}")
    public ResponseEntity<EmployeeEntity> getEmployeeDetails (@PathVariable String employeeId)
    {
        return new ResponseEntity(employeeService.findEmployeeById(employeeId),HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployeeDetails/{employeeId}")
    public ResponseEntity<String> deleteEmployeeDetails(@PathVariable String employeeId)
    {
        return new ResponseEntity(employeeService.deleteEmployeeById(employeeId),HttpStatus.OK);
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployeeDetails()
    {
        return new ResponseEntity(employeeService.findAllEmployee(),HttpStatus.OK);
    }

    @GetMapping("/getManagerDetails/{employeeId}")
    public ResponseEntity<ManagerEntity> getManagerDetails(String employeeId)
    {
        return new ResponseEntity(employeeService.getDeatilsOfManagerByEmployeeId(employeeId),HttpStatus.OK);
    }

    @GetMapping("/getEmployeesUnderManager/{managerId}")
    public ResponseEntity<EmployeeUnderManagerDto> getAllEmployeeUnderOneManager(String mangerId)
    {
        return new ResponseEntity(employeeService.employeeUnderManager(mangerId),HttpStatus.OK);
    }


}
