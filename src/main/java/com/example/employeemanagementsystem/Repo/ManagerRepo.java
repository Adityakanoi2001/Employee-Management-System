package com.example.employeemanagementsystem.Repo;


import com.example.employeemanagementsystem.Entities.ManagerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepo extends MongoRepository<ManagerEntity,String>
{
}
