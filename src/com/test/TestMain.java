package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.Room;
import com.util.ConnectionUtil;

public class TestMain {
	public static void main(String[] args) {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select room_id from room_guest where guest_id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, 1);
			ResultSet rs = stmt.executeQuery();
			int room_id = 0;
			while(rs.next()) {
				room_id = rs.getInt(1);
			}
			System.out.println("room id = "+room_id);
			sql = "select * from room where room_id = ?";
			PreparedStatement stmt1 = con.prepareStatement(sql);
			stmt1.setInt(1, room_id);
			ResultSet rs1 = stmt1.executeQuery();
			while(rs1.next()) {
				Room room = new Room();
				room.setRoomId(rs1.getInt("room_id"));
				System.out.println("id = "+room.getRoomId());
				room.setRoomType(rs1.getInt("room_type"));
				System.out.println("room type = "+room.getRoomType());
				room.setCapacity(rs1.getInt("capacity"));
				System.out.println("cap = "+room.getCapacity());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}