package com.dao;
import java.util.List;

import com.dto.Guest;

public interface GuestDao {
	public List<Guest> getAllGuests();
	public List<Guest> getGuestsByRoomNo(int roomNo);
	public Guest getGuestById(int guestiId);
	public void addGuestToRoom(Guest guest);
	public void vacateGuestFromRoom(Guest guest);
	public void updateGuest(Guest guest);
}
