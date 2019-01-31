package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBConnector;

public class ItemAddDAO {

	private int insert_number;

	//管理者用商品登録
	public int Insert(String AddItemName, int AddItemPrice, String AddItemCategory, String AddItemDiscription) {
		DBConnector DBcon = new DBConnector();
		Connection con = DBcon.getConnection();
		String sql = "insert into items(buyItemName, buyItemPrice, Category, discription, imagePath) values(?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, AddItemName);
			ps.setInt(2, AddItemPrice);
			ps.setString(3, AddItemCategory);
			ps.setString(4, AddItemDiscription);
			ps.setString(5, "photos/sampleImage.png");
			insert_number = ps.executeUpdate();

			con.close();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return insert_number;
	}


	//管理者用ユーザー登録
	public int Insert(String AddUserName, String AddUserPassword) {
		DBConnector DBcon = new DBConnector();
		Connection con = DBcon.getConnection();
		String sql = "insert into users(user_name, password) values(?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, AddUserName);
			ps.setString(2, AddUserPassword);
			insert_number = ps.executeUpdate();

			con.close();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return insert_number;
	}

}
