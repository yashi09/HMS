package com.service.impl;

import java.util.List;

import com.dao.RoomDao;
import com.dao.impl.RoomDaoImpl;
import com.dto.Room;
import com.service.RoomService;

public class RoomServiceImpl implements RoomService{
	RoomDao roomDao = new RoomDaoImpl();
	@Override
	public List<Room> getAllVacantRooms() {
		return roomDao.getAllVacantRooms();
	}

	@Override
	public List<Room> getAllRooms() {
		return roomDao.getAllRooms();
	}

	@Override
	public List<Room> getRoomsByCapacity(int capacity) {
		return roomDao.getRoomsByCapacity(capacity);
	}

	@Override
	public List<Room> getRoomsByType(int type) {
		return roomDao.getRoomsByType(type);
	}

	@Override
	public void updateRoom(Room room) {
		roomDao.updateRoom(room);
	}

	@Override
	public void destroyRoom(int roomNo) {
		roomDao.destroyRoomByRoomNo(roomNo);
	}

	@Override
	public Room getRoom(int roomNo) {
		return roomDao.getRoomByRoomNo(roomNo);
	}

	@Override
	public void addRoom(Room room) {
		roomDao.addRoomToHotel(room);
	}
}