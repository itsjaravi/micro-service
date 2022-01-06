package com.java.jay.departmentservice.serviceimpl;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.jay.departmentservice.entity.Department;
import com.java.jay.departmentservice.repository.DepartmentRepository;
import com.java.jay.departmentservice.service.DepartmentService;

@Service("departmentserviceImpl")
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
    private DepartmentRepository departmentRepository;

	@Override
	@Transactional
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	@Transactional
	public Department findDepartmentById(Long departmentId) {
		return departmentRepository.findByDepartmentId(departmentId);
	}

	@Override
	@Transactional
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteByDepartmentId(departmentId);
		
	}

	@Override
	@Transactional
	public void updateDepartmentById(Department department, Long departmentId) {
		
		Optional<Department> newDepartment = departmentRepository.findById(departmentId);
		newDepartment.get().setDepartmentAddress(department.getDepartmentAddress());
		newDepartment.get().setDepartmentCode(department.getDepartmentCode());
		newDepartment.get().setDepartmentName(department.getDepartmentName());
	}

	@Override
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	@Override
	public void deleteAll() {
		departmentRepository.deleteAll();
	}
	
	

}
