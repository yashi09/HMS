package com.dao;

import java.util.List;

import com.dto.Department;

public interface DepartmentDao {
	public void addDepartment(Department department);
	public Department getDepartmentById(int deptId);
	public Department getDepartmentByCode(int code);
	public void updateDepatrment(Department department);
	public void deleteDepartment(int deptId);
	public List<Department> getAllDepartments();
}
