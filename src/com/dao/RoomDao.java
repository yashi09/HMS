package com.dao;

import java.util.List;

import com.dto.Room;

public interface RoomDao {
	public List<Room> getAllVacantRooms();
	public List<Room> getAllRooms();
	public List<Room> getRoomsByCapacity(int capacity);
	public List<Room> getRoomsByType(int type);
	public void updateRoom(Room room);
	public void vacateRoomByRoomNo(int roomNo);
	public Room getRoomByRoomNo(int roomNo);
	public void addRoomToHotel(Room room);
}
