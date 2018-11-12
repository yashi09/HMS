package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.StaffDao;
import com.dto.Department;
import com.dto.Staff;
import com.util.ConnectionUtil;

public class StaffDaoImpl implements StaffDao{
	private Connection con = null;
	@Override
	public List<Staff> getAllStaffDetails() {
		con = ConnectionUtil.getConnection();
		List<Staff> staffList = new ArrayList<Staff>();
		String sql = "select * from staff";
		String sqlDept = "select * from department where dept_id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			PreparedStatement stmt1 = con.prepareStatement(sqlDept);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Staff staffMember = new Staff();
				stmt1.setInt(1, rs.getInt("dept_id"));
				ResultSet rs1 = stmt.executeQuery();
				while(rs1.next()) {
					Department department = new Department();
					department.setDeptCode(rs1.getInt("dept_code"));
					department.setDeptId(rs1.getInt("dept_id"));
					department.setDeptName(rs1.getString("dept_name"));
					staffMember.setDepartment(department);
				}
				staffMember.setName(rs.getString("name"));
				staffMember.setRole(rs.getString("role"));
				staffMember.setStaffId(rs.getInt("staff_id"));
				staffList.add(staffMember);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return staffList;
	}

	@Override
	public List<Staff> getStaffOfDept(int deptCode) {
		con = ConnectionUtil.getConnection();
		List<Staff> staffList = new ArrayList<Staff>();
		String sql = "select * from staff where dept_code = "+deptCode;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Staff staffMember = new Staff();
				staffMember.setName(rs.getString("name"));
				staffMember.setRole(rs.getString("role"));
				staffMember.setStaffId(rs.getInt("staff_id"));
				
				Department department = new Department();
				department.setDeptCode(deptCode);
				staffMember.setDepartment(department);
				staffList.add(staffMember);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return staffList;
	}

	@Override
	public List<Staff> getStaffByRole(String role) {
		con = ConnectionUtil.getConnection();
		List<Staff> staffList = new ArrayList<Staff>();
		String sql = "select * from staff where role = '"+role+"'";
		//String sql1 = "select * from department where dept_code = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			//PreparedStatement stmt1 = con.prepareStatement(sql1);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Staff staffMember = new Staff();
				/*stmt1.setInt(1, rs.getInt("dept_code"));
				ResultSet rs1 = stmt1.executeQuery();
				while(rs1.next()) {
					Department department = new Department();
					department.set
					staffMember.setDepartment(department);
				}*/
				staffMember.setName(rs.getString("name"));
				staffMember.setRole(rs.getString("role"));
				staffMember.setStaffId(rs.getInt("staff_id"));
				staffList.add(staffMember);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return staffList;
	}

	@Override
	public Staff getStaffById(int staffId) {
		con = ConnectionUtil.getConnection();
		Staff staff = new Staff();
		String sql = "select * from staff where staff_id = "+staffId;
		String sql1 = "select * from department where dept_code = '?'";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			PreparedStatement stmt1 = con.prepareStatement(sql1);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				staff.setName(rs.getString("name"));
				staff.setRole(rs.getString("role"));
				staff.setStaffId(rs.getInt("staff_id"));
				stmt1.setInt(1, rs.getInt("dept_code"));
				ResultSet rs1 = stmt1.executeQuery();
				while(rs1.next()) {
					Department department = new Department();
					department.setDeptCode(rs1.getInt("dept_code"));
					department.setDeptId(rs1.getInt("dept_id"));
					department.setDeptName(rs1.getString("dept_name"));
					staff.setDepartment(department);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		return staff;
	}

	@Override
	public void removeStaffById(int staffId) {
		con = ConnectionUtil.getConnection();
		String sql = "delete from staff where staff_id = "+staffId;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addStaffToHotel(Staff staff) {
		con = ConnectionUtil.getConnection();
		String sql = "insert into staff(name, role, dept_code) values(?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, staff.getName());
			stmt.setString(2, staff.getRole());
			stmt.setInt(3, staff.getDepartment().getDeptCode());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStaffDetails(Staff staff) {
		con = ConnectionUtil.getConnection();
		String sql = "update staff set name = ?, role = ?, dept_code = ? where staff_id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, staff.getName());
			stmt.setString(2, staff.getRole());
			stmt.setInt(3, staff.getStaffId());
			stmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}