package com.dto;

import java.util.List;

public class Hotel {
	private int hotelId;
	private List<Room> rooms;
	private List<Staff> staff;
	private List<Guest> guest;
	private List<Department> depts;
	
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	public List<Staff> getStaff() {
		return staff;
	}
	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}
	public List<Guest> getGuest() {
		return guest;
	}
	public void setGuest(List<Guest> guest) {
		this.guest = guest;
	}
	public List<Department> getDepts() {
		return depts;
	}
	public void setDepts(List<Department> depts) {
		this.depts = depts;
	}
}