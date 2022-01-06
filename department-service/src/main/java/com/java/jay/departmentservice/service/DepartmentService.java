package com.java.jay.departmentservice.service;

import java.util.List;

import org.springframework.stereotype.Component;
import com.java.jay.departmentservice.entity.Department;

@Component
public interface DepartmentService {


    public Department saveDepartment(Department department); 

    public Department findDepartmentById(Long departmentId) ;

	public void deleteDepartmentById(Long departmentId);

	public void updateDepartmentById(Department department, Long departmentId);

	public List<Department> findAll();

	public void deleteAll(); 
    
}