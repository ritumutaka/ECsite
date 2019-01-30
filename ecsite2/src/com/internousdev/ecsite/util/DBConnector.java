package com.internousdev.ecsite.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	private String driverName = "com.mysql.jdbc.Driver";

	private String url = "jdbc:mysql://localhost/ecsite2";

	private String user = "root";

	private String password = "mysql";


	public Connection getConnection(){
		Connection con = null;

		try {
			Class.forName(driverName);
			//(Connection)？？
			con = (Connection) DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
