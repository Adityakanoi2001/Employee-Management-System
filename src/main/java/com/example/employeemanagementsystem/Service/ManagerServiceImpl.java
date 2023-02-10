package com.example.employeemanagementsystem.Service;

import com.example.employeemanagementsystem.Dtos.ManagerInputDto;
import com.example.employeemanagementsystem.Entities.ManagerEntity;
import com.example.employeemanagementsystem.Repo.ManagerRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerRepo managerRepo;

    @Autowired
    MongoTemplate mongoTemplate;




    @Override
    public String saveManagerDetails(ManagerInputDto managerInputDto) {
        ManagerEntity managerEntity = new ManagerEntity();
        BeanUtils.copyProperties(managerInputDto,managerEntity);
        managerEntity.setManagerId(UUID.randomUUID().toString());
        if(managerInputDto.getParentId()=="" || managerInputDto.getParentId()==null)
        {
            managerRepo.save(managerEntity);
            return "Manager Saved : "+managerInputDto.getFirstName()+ "\n"+ "Your Manager Id is : "+managerEntity.getManagerId() + "\n"+"TOP LEVEL MANAGER BHAI ! INSE UPAR KOI NAHI";
        }
        else
        {
            managerRepo.save(managerEntity);
            return ("Manager Saved : "+managerInputDto.getFirstName()+ "\n"+ "Your Manager Id is : "+managerEntity.getManagerId());
        }

    }

    @Override
    public Optional<ManagerEntity> findManagerById(String managerId) {
        return managerRepo.findById(managerId);
    }

    @Override
    public String deleteManagerById(String managerId) {
        managerRepo.deleteById(managerId);
        return "Manager Successfully Deleted with ID :"+managerId;
    }

    @Override
    public List<ManagerEntity> findAllManager()
    {
        return managerRepo.findAll();
    }

    @Override
    public List<ManagerEntity> allManagerUnderSuperiorManager(String managerId)
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("parentId").is(managerId));
        List<ManagerEntity> managerEntityList = mongoTemplate.find(query,ManagerEntity.class);
        return managerEntityList;

    }


    // TODO: 09/02/23 multiple managers checks;

    @Override
    public List<Optional<ManagerEntity>> getAboveManager(String managerId) {

        List<Optional<ManagerEntity>> managerEntityList = new ArrayList<>();
        Optional<ManagerEntity> managerEntity = managerRepo.findById(managerId);
        while(managerEntity.isPresent())
        {
            if(managerEntity.get().getParentId()!=null || managerEntity.get().getParentId()!="")
            {
                managerEntityList.add(managerRepo.findById(managerEntity.get().getParentId()));
                if(managerEntity.get().getParentId()!=null)
                {
                    managerEntity=managerRepo.findById(managerEntity.get().getParentId());
                }
            }
        }

        return managerEntityList;


    }





}
