package com.service;

import java.util.List;

import com.dto.Staff;

public interface StaffService {
	public List<Staff> getAllStaffDetails();
	public List<Staff> getStaffByDept(int deptCode);
	public List<Staff> getStaffByRole(String role);
	public Staff getStaff(int staffId);
	public void removeStaff(int staffId);
	public void addStaff(Staff staff);
	public void updateStaffDetails(Staff staff);
}