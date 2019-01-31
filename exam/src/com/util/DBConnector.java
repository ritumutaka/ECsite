package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/exam";
	private String user = "root";
	private String password = "mysql";
	
	//getoConnection()内は理解していない
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = (Connection) DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
