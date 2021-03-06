package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection con = null;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if(con==null || con.isClosed()) {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "admin");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection() {
		try {
			if(con!=null || !con.isClosed()) {
				con.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/sonoo","root","root");  
	//here sonoo is database name, root is username and password  
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("select * from emp");  
	while(rs.next())  
	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	con.close();  
	}catch(Exception e){ System.out.println(e);}  
	}  
	}  */
}