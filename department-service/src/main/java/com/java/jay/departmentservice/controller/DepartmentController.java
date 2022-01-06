package com.java.jay.departmentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.jay.departmentservice.entity.Department;
import com.java.jay.departmentservice.service.DepartmentService;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        return  departmentService.saveDepartment(department);
    }
    
    @GetMapping("/getall")
    public List<Department> getAllDepartments(){
    	
    	return this.departmentService.findAll();
    	
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentService.findDepartmentById(departmentId);
    }
    
   @DeleteMapping("/delete/{id}")
    @ResponseBody 
    public void deleteDepartment (@PathVariable("id") Long departmentId) {
    	departmentService.deleteDepartmentById(departmentId);
    }
   
   @DeleteMapping("/deleteall")
   @ResponseBody 
   public void deleteAllDepartment (Long departmentId) {
   	departmentService.deleteAll();
   }
   
   @PutMapping("/update/{id}")
   public void updateDepartment(@RequestBody Department department , @PathVariable("id") Long departmentId) {
	   
	   departmentService.updateDepartmentById(department,departmentId);
	   
   }

}
