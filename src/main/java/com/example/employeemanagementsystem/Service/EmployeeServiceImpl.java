package com.example.employeemanagementsystem.Service;

import com.example.employeemanagementsystem.Dtos.EmployeeInputDto;
import com.example.employeemanagementsystem.Dtos.EmployeeUnderManagerDto;
import com.example.employeemanagementsystem.Dtos.EmployeeUpdateDto;
import com.example.employeemanagementsystem.Entities.EmployeeEntity;
import com.example.employeemanagementsystem.Entities.ManagerEntity;
import com.example.employeemanagementsystem.Repo.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    ManagerService managerService;

    @Override
    public String saveEmployeeDetails(EmployeeInputDto employeeInputDto) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeInputDto,employeeEntity);
        employeeEntity.setEmployeeId(UUID.randomUUID().toString());
        employeeRepository.save(employeeEntity);
        String message = "Employee Details Saved SuccessFully with Name : " + employeeEntity.getFirstName() + "\n" + " Your Employee Id is :" + employeeEntity.getEmployeeId();
        return (message);
    }

    @Override
    public Optional<EmployeeEntity> findEmployeeById(String employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public String deleteEmployeeById(String employeeId)
    {
        employeeRepository.deleteById(employeeId);
        return ("Deleted Successfully Employee : "+ employeeRepository.findById(employeeId).get().getFirstName());
    }

    @Override
    public List<EmployeeEntity> findAllEmployee() {
        return (employeeRepository.findAll());
    }

    @Override
    public Optional<ManagerEntity> getDeatilsOfManagerByEmployeeId(String employeeId)
    {

        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);
        if(employeeEntity.isPresent())
        {
            Optional<ManagerEntity> managerEntity = managerService.findManagerById(employeeEntity.get().getManagerId());
            return managerEntity;
        }
        else
        {
        return null;
        }
    }

    @Override
    public EmployeeUnderManagerDto employeeUnderManager(String managerId)
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("managerId").is(managerId));
        List<EmployeeEntity> employeeEntityList = mongoTemplate.find(query,EmployeeEntity.class);
        EmployeeUnderManagerDto employeeUnderManagerDto = new EmployeeUnderManagerDto();
        employeeUnderManagerDto.setEmployeeEntityList(employeeEntityList);
        employeeUnderManagerDto.setNumberofemployee(employeeEntityList.size());
        return employeeUnderManagerDto;
    }

    @Override
    public String updateEmployeeDetails(EmployeeUpdateDto employeeUpdateDto)
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("employeeId").is(employeeUpdateDto.getEmployeeId()));
        List<EmployeeEntity> employeeEntity1 = mongoTemplate.find(query,EmployeeEntity.class);
        BeanUtils.copyProperties(employeeEntity1.get(0),employeeUpdateDto);
        employeeRepository.save(employeeEntity1.get(0));
        return "Details Modified with User id :"+employeeUpdateDto.getEmployeeId();
    }




}
