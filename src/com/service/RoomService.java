package com.service;

import java.util.List;

import com.dto.Guest;
import com.dto.Room;
import com.dto.Staff;

public interface RoomService {
	public List<Room> getAllVacantRooms();
	public List<Room> getAllRooms();
	public List<Room> getRoomsByCapacity(int capacity);
	public List<Room> getRoomsByType(int type);
	public void updateRoom(Room room);
	public void vacateRoom(int roomNo);
	public Room getRoom(int roomNo);
	public void addRoom(Room room);
}