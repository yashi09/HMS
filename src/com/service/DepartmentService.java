package com.service;

import java.util.List;

import com.dto.Department;

public interface DepartmentService {
	public void addDepartment(Department department);
	public Department getDepartmentById(int deptId);
	public Department getDepartmentByCode(int code);
	public void updateDepartment(Department department);
	public void deleteDepartment(int deptId);
	public List<Department> getAllDepartments();
}
