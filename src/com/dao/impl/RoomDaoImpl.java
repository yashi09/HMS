package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.RoomDao;
import com.dto.Guest;
import com.dto.Room;
import com.util.ConnectionUtil;

public class RoomDaoImpl implements RoomDao{
	private Connection con = null;
	@Override
	public List<Room> getAllVacantRooms() {
		con = ConnectionUtil.getConnection();
		List<Room> vacatedRooms = new ArrayList<Room>();
		String sqlVacantRoom = "select * from room r where r.room_id NOT IN(select d.room_id from room_guest d)";
		try {
			PreparedStatement stmt = con.prepareStatement(sqlVacantRoom);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Room room = new Room();
				room.setCapacity(rs.getInt("capacity"));
				room.setRoomId(rs.getInt("room_id"));
				room.setRoomNo(rs.getInt("room_no"));
				room.setRoomType(rs.getInt("room_type"));
				vacatedRooms.add(room);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return vacatedRooms;
	}

	@Override
	public List<Room> getAllRooms() {
		con = ConnectionUtil.getConnection();
		List<Room> roomList = null;
		String roomSql = "select * from room";
		String roomGuestSql = "select * from guest where guest_id IN (select guest_id from room_guest where room_id IN (?))";
		try {
			PreparedStatement stmt = con.prepareStatement(roomSql);
			PreparedStatement stmt1 = con.prepareStatement(roomGuestSql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Room room = new Room();
				room.setCapacity(rs.getInt("capacity"));
				room.setRoomId(rs.getInt("room_id"));
				room.setRoomNo(rs.getInt("room_no"));
				room.setRoomType(rs.getInt("room_type"));
				List<Guest> guests = new ArrayList<Guest>();
				stmt1.setInt(1, room.getRoomId());
				ResultSet rs1 = stmt1.executeQuery();
				while(rs1.next()) {
					Guest guest = new Guest();
					guest.setAge(rs1.getInt("age"));
					guest.setCity(rs1.getString("city"));
					guest.setContactNo(rs1.getLong("contact"));
					guest.setGuestId(rs1.getInt("guest_id"));
					guest.setName(rs1.getString("name"));
					guest.setRoom(room);
					guests.add(guest);
				}
				room.setGuests(guests);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return roomList;
	}

	@Override
	public List<Room> getRoomsByCapacity(int capacity) {
		con = ConnectionUtil.getConnection();
		List<Room> rooms = new ArrayList<Room>();
		String sql = "select * from room where capacity = "+capacity;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Room room = new Room();
				room.setCapacity(rs.getInt("capacity"));
				room.setRoomId(rs.getInt("room_id"));
				room.setRoomNo(rs.getInt("room_no"));
				room.setRoomType(rs.getInt("room_type"));
				rooms.add(room);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rooms;
	}

	@Override
	public List<Room> getRoomsByType(int type) {
		con = ConnectionUtil.getConnection();
		List<Room> rooms = new ArrayList<Room>();
		String sql = "select * from room where room_type = "+type;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Room room = new Room();
				room.setCapacity(rs.getInt("capacity"));
				room.setRoomId(rs.getInt("room_id"));
				room.setRoomNo(rs.getInt("room_no"));
				room.setRoomType(rs.getInt("room_type"));
				rooms.add(room);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return rooms;
	}

	@Override
	public void updateRoom(Room room) {
		con = ConnectionUtil.getConnection();
		String sql = "update room set room_no = ?, capacity = ?, room_type = ? where room_id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, room.getRoomNo());
			stmt.setInt(2, room.getCapacity());
			stmt.setInt(3, room.getRoomType());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void vacateRoomByRoomNo(int roomNo) {
		con = ConnectionUtil.getConnection();
		String sql = "delete from room_guest where room_no = "+roomNo;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Room getRoomByRoomNo(int roomNo) {
		con = ConnectionUtil.getConnection();
		String sql = "select * from room where room_no = "+roomNo;
		Room room = new Room();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				room.setCapacity(rs.getInt("capacity"));
				room.setRoomId(rs.getInt("room_id"));
				room.setRoomNo(rs.getInt("room_no"));
				room.setRoomType(rs.getInt("room_type"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return room;
	}

	@Override
	public void addRoomToHotel(Room room) {
		con = ConnectionUtil.getConnection();
		String sql = "insert into room (capacity, room_no, room_type) values(?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, room.getCapacity());
			stmt.setInt(2, room.getRoomNo());
			stmt.setInt(3, room.getRoomType());
			stmt.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
