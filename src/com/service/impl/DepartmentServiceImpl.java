package com.service.impl;

import java.util.List;

import com.dao.DepartmentDao;
import com.dao.impl.DepartmentDaoImpl;
import com.dto.Department;
import com.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{
	DepartmentDao departmentDao = new DepartmentDaoImpl();
	@Override
	public void addDepartment(Department department) {
		departmentDao.addDepartment(department);
	}

	@Override
	public Department getDepartmentById(int deptId) {
		return departmentDao.getDepartmentById(deptId);
		
	}

	@Override
	public void updateDepartment(Department department) {
		departmentDao.updateDepartment(department);
	}

	@Override
	public void deleteDepartment(int deptId) {
		departmentDao.deleteDepartment(deptId);
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentDao.getAllDepartments();
	}

	@Override
	public Department getDepartmentByCode(int code) {
		return departmentDao.getDepartmentByCode(code);
	}
}