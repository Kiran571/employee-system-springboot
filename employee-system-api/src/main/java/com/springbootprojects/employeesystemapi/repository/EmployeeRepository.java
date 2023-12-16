package com.springbootprojects.employeesystemapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootprojects.employeesystemapi.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{
    
}
