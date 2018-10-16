package com.service.impl;

import java.util.List;

import com.dao.StaffDao;
import com.dao.impl.StaffDaoImpl;
import com.dto.Staff;
import com.service.StaffService;

public class StaffServiceImpl implements StaffService{
	StaffDao staffDao = new StaffDaoImpl();
	@Override
	public List<Staff> getAllStaffDetails() {
		// TODO Auto-generated method stub
		return staffDao.getAllStaffDetails();
	}

	@Override
	public List<Staff> getStaffByDept(int deptCode) {
		return staffDao.getStaffByDept(deptCode);
	}

	@Override
	public List<Staff> getStaffByRole(String role) {
		return staffDao.getStaffByRole(role);
	}

	@Override
	public Staff getStaff(int staffId) {
		return staffDao.getStaffById(staffId);
	}

	@Override
	public void removeStaff(int staffId) {
		staffDao.removeStaffById(staffId);
	}

	@Override
	public void addStaff(Staff staff) {
		staffDao.addStaffToHotel(staff);
	}

	@Override
	public void updateStaffDetails(Staff staff) {
		staffDao.updateStaffDetails(staff);
	}
}