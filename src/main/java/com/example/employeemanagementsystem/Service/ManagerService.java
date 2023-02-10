package com.example.employeemanagementsystem.Service;

import com.example.employeemanagementsystem.Dtos.ManagerInputDto;
import com.example.employeemanagementsystem.Entities.ManagerEntity;
import java.util.List;
import java.util.Optional;

public interface ManagerService
{

    public String saveManagerDetails (ManagerInputDto managerInputDto);
    public Optional<ManagerEntity> findManagerById (String managerId);
    public String deleteManagerById(String managerId);
    public List<ManagerEntity> findAllManager();
    public List<ManagerEntity> allManagerUnderSuperiorManager(String managerId);
    public List<Optional<ManagerEntity>> getAboveManager(String managerId);
}
