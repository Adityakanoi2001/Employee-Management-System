package com.example.employeemanagementsystem.Repo;

import com.example.employeemanagementsystem.Entities.EmployeeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<EmployeeEntity,String>
{

}
