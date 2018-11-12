package com.dto;

import java.util.Date;

public class Guest {
	private int guestId;
	private String name;
	private int age;
	private String address;
	private long contactNo;
	private Room room;
	private Date checkIn;
	private Date checkOut;
	
	public int getGuestId() {
		return guestId;
	}
	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Room getRoom() {
		return room;
	}
}