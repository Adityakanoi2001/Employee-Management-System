package com.example.employeemanagementsystem.Service;

import com.example.employeemanagementsystem.Dtos.EmployeeInputDto;
import com.example.employeemanagementsystem.Dtos.EmployeeUnderManagerDto;
import com.example.employeemanagementsystem.Dtos.EmployeeUpdateDto;
import com.example.employeemanagementsystem.Entities.EmployeeEntity;
import com.example.employeemanagementsystem.Entities.ManagerEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public String saveEmployeeDetails (EmployeeInputDto employeeInputDto);
    public Optional<EmployeeEntity> findEmployeeById (String employeeId);
    public String deleteEmployeeById(String employeeId);
    public List<EmployeeEntity> findAllEmployee ();
    public Optional<ManagerEntity> getDeatilsOfManagerByEmployeeId(String employeeId);
    public EmployeeUnderManagerDto employeeUnderManager(String managerId);
    public String updateEmployeeDetails(EmployeeUpdateDto employeeUpdateDto);


}
