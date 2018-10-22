package com.service.impl;

import java.util.List;

import com.dao.GuestDao;
import com.dao.impl.GuestDaoImpl;
import com.dto.Guest;
import com.service.GuestService;

public class GuestServiceImpl implements GuestService{
	GuestDao guestDao = new GuestDaoImpl();
	@Override
	public List<Guest> getAllGuests() {
		return guestDao.getAllGuests();
	}

	@Override
	public List<Guest> getGuestsByRoomNo(int roomNo) {
		return guestDao.getGuestsByRoomNo(roomNo);
	}

	@Override
	public Guest getGuest(int guestiId) {
		return guestDao.getGuestById(guestiId);
	}

	@Override
	public void addGuest(Guest guest) {
		guestDao.addGuestToRoom(guest);
	}

	@Override
	public void vacateGuest(Guest guest) {
		guestDao.vacateGuestFromRoom(guest);
	}

	@Override
	public void updateGuest(Guest guest) {
		guestDao.updateGuest(guest);
	}
}