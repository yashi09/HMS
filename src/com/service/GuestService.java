package com.service;

import java.util.List;

import com.dto.Guest;

public interface GuestService {
	public List<Guest> getAllGuests();
	public List<Guest> getGuestsByRoomNo(int roomNo);
	public Guest getGuest(int guestiId);
	public void addGuest(Guest guest);
	public void vacateGuest(Guest guest);
	public void updateGuest(Guest guest);
}
