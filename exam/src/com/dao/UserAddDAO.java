package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBConnector;

public class UserAddDAO {

	private int insert_number;
	
	public int Insert(String AddUserName, int AddUserPassword) {
		DBConnector DBcon = new DBConnector();
		Connection con = DBcon.getConnection();
		String sql = "insert into users(user_name, password) values(?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, AddUserName);
			ps.setInt(2, AddUserPassword);
			insert_number = ps.executeUpdate();
			
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return insert_number;
	}
	
}
