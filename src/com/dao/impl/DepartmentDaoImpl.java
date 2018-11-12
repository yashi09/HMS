package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.DepartmentDao;
import com.dto.Department;
import com.util.ConnectionUtil;

public class DepartmentDaoImpl implements DepartmentDao {
	Connection connection = null;
	@Override
	public void addDepartment(Department department) {
		if(connection==null)
			connection = ConnectionUtil.getConnection();
		System.out.println("in dept dao impl");
		try{
			String sql = "insert into department(dept_code, dept_name) values(?,?);";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, department.getDeptCode());
			stmt.setString(2, department.getDeptName());
			stmt.execute();
			System.out.println("added");
		} catch(SQLException e){
			e.printStackTrace();
		} 
	}

	@Override
	public Department getDepartmentById(int deptId) {
		Department department = new Department();
		if(connection == null)
			connection= ConnectionUtil.getConnection();
		String sql = "select * from department where dept_id=?";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, deptId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				department.setDeptCode(rs.getInt("dept_code"));
				department.setDeptId(rs.getInt("dept_id"));
				department.setDeptName(rs.getString("dept_name"));
				System.out.println(department.getDeptId()+",,,"+department.getDeptCode()+",,"+department.getDeptName());
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return department;
	}

	@Override
	public void updateDepartment(Department department) {
		if(connection==null)
			connection = ConnectionUtil.getConnection();
		String sql = "update department set dept_code=?,dept_name=? where dept_id=?";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, department.getDeptCode());
			stmt.setString(2, department.getDeptName());
			stmt.setInt(3, department.getDeptId());
			stmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void deleteDepartment(int deptId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> depts = new ArrayList<Department>();
		if(connection==null)
			connection = ConnectionUtil.getConnection();
		String sql = "select * from department";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Department dept = new Department();
				dept.setDeptCode(rs.getInt("dept_code"));
				dept.setDeptId(rs.getInt("dept_id"));
				dept.setDeptName(rs.getString("dept_name"));
				depts.add(dept);
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return depts;
	}

	@Override
	public Department getDepartmentByCode(int code) {
		if(connection==null)
			connection = ConnectionUtil.getConnection();
		String sql = "select 8 from department where dept_code = ?";
		Department department = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, code);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				department = new Department();
				department.setDeptCode(rs.getInt("dept_code"));
				department.setDeptId(rs.getInt("dept_id"));
				department.setDeptName(rs.getString("dept_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return department;
	}

}
