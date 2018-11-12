package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.dao.GuestDao;
import com.dto.Guest;
import com.dto.Room;
import com.util.ConnectionUtil;

public class GuestDaoImpl implements GuestDao{
	private Connection con = null;

	@Override
	public List<Guest> getAllGuests() {
		con = ConnectionUtil.getConnection();
		String sql = "select * from guest";
		String sql1 = "select room_id from room_guest where guest_id = ?";
		String sql2 = "select * from room where room_id = ?";

		List<Guest> guests = new ArrayList<Guest>();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			PreparedStatement stmt1 = con.prepareStatement(sql1);
			PreparedStatement stmt2 = con.prepareStatement(sql2);
			ResultSet rs = stmt.executeQuery(sql);
			//fetch guests
			while(rs.next()) {
				Guest guest = new Guest();
				guest.setGuestId(rs.getInt("guest_id"));
				guest.setName(rs.getString("name"));
				guest.setAge(rs.getInt(rs.getInt("age")));
				guest.setAddress(rs.getString("address"));
				guest.setContactNo(rs.getLong("contact"));
				Room room = new Room();
				stmt1.setInt(0, guest.getGuestId());
				ResultSet rs1 = stmt1.executeQuery(sql1);
				int roomId=0;
				//fetch room ids
				while(rs1.next()) {
					roomId = rs1.getInt("room_id");
				}
				stmt2.setInt(1, roomId);
				ResultSet rs2 = stmt2.executeQuery();
				//fetch rooms
				while(rs2.next()) {
					room.setRoomId(rs2.getInt("room_id"));
					room.setCapacity(rs2.getInt("capacity"));
					room.setRoomType(rs2.getInt("room_type"));
				}
				guest.setRoom(room);
				guests.add(guest);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return guests;
	}

	@Override
	public List<Guest> getGuestsByRoomNo(int roomNo) {
		List<Guest> guests = new LinkedList<Guest>();
		con = ConnectionUtil.getConnection();
		String sql = "select guest_id from room_guest where room_no = ?";
		String sql1 = "select * from guest where guest_id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			PreparedStatement stmt1 = con.prepareStatement(sql1);
			stmt.setInt(1, roomNo);
			ResultSet rs = stmt.executeQuery();
			ResultSet rs1;
			int guestId=0;
			while(rs.next()) {
				guestId = rs.getInt(1);
				stmt1.setInt(1, guestId);
				rs1 = stmt1.executeQuery();
				while(rs1.next()) {
					Guest guest = new Guest();
					guest.setGuestId(rs1.getInt("guest_id"));
					guest.setAge(rs1.getInt("age"));
					guest.setAddress(rs1.getString("address"));
					guest.setContactNo(rs1.getLong("contact"));
					guest.setName(rs1.getString("name"));
					guests.add(guest);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.closeConnection();
		}
		return guests;
	}

	@Override
	public Guest getGuestById(int guestiId) {
		Guest guest = null;
		con = ConnectionUtil.getConnection();
		String sql  = "select * from guest where guest_id = ?";
		String sql1 = "select room_id from room_guest where guest_id = ?";
		String sql2 = "select * from room where room_id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, guestiId);
			PreparedStatement stmt1 = con.prepareStatement(sql1);
			stmt1.setInt(1, guestiId);
			PreparedStatement stmt2 = con.prepareStatement(sql2);
			ResultSet rs = stmt.executeQuery();
			//fetch guest
			while(rs.next()) {
				guest = new Guest();
				guest.setAge(rs.getInt("age"));
				guest.setAddress(rs.getString("address"));
				guest.setContactNo(rs.getLong("contact"));
				guest.setGuestId(rs.getInt("guest_id"));
				guest.setName(rs.getString("name"));
			}
			ResultSet rs1 = stmt1.executeQuery();
			//fetch roomId
			rs1.next();
			int roomId = rs1.getInt(1);
			stmt2.setInt(1, roomId);
			ResultSet rs2 = stmt2.executeQuery();
			//fetch room
			while(rs2.next()) {
				Room room = new Room();
				room.setCapacity(rs2.getInt("capacity"));
				room.setRoomId(rs2.getInt("room_id"));
				room.setRoomType(rs2.getInt("room_type"));
				guest.setRoom(room);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection();
		}
		return guest;
	}

	@Override
	public void addGuestToRoom(Guest guest){
		con = ConnectionUtil.getConnection();
		String sql = "insert into guest (name,age,address,contact,room_no) values(?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, guest.getName());
			stmt.setInt(2, guest.getAge());
			stmt.setString(3, guest.getAddress());
			stmt.setLong(4, guest.getContactNo());
			stmt.setInt(5, guest.getRoom().getRoomNo());
			ResultSet rs = stmt.executeQuery();
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection();
		}
	}

	@Override
	public void vacateGuestFromRoom(Guest guest) {
		con = ConnectionUtil.getConnection();
		String sql = "delete from room_guest where guest_id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, guest.getGuestId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection();
		}
		
	}

	@Override
	public void updateGuest(Guest guest) {
		con = ConnectionUtil.getConnection();
		String sql = "update guest set name=?, age=?, address=?, contact=?, room_no=? where guest_id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, guest.getName());
			stmt.setInt(2, guest.getAge());
			stmt.setString(3, guest.getAddress());
			stmt.setLong(4, guest.getContactNo());
			stmt.setInt(5, guest.getRoom().getRoomNo());
			stmt.setInt(6, guest.getGuestId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection();
		}	
	}
}