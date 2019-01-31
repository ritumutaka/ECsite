package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBConnector;

public class AddressResetDAO {
	
	private int i;

	public void addAddress(int userIdNumber, String Country, String State, String Contact) {
		DBConnector DBcon = new DBConnector();
		Connection con = DBcon.getConnection();
		String sql = "insert into address(UserIdNumber, Country, State, Contact) values(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userIdNumber);
			ps.setString(2, Country);
			ps.setString(3, State);
			ps.setString(4, Contact);
			i = ps.executeUpdate();
			
			if(i > 0) {
				System.out.println(i + "件、宛先を追加しました");
			} else {
				System.out.println("宛先を追加できませんでした。");
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
