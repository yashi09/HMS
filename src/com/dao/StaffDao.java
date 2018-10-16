package com.dao;

import java.util.List;

import com.dto.Staff;

public interface StaffDao {
	public List<Staff> getAllStaffDetails();
	public List<Staff> getStaffByDept(int deptCode);
	public List<Staff> getStaffByRole(String role);
	public Staff getStaffById(int staffId);
	public void removeStaffById(int staffId);
	public void addStaffToHotel(Staff staff);
	public void updateStaffDetails(Staff staff);
}
