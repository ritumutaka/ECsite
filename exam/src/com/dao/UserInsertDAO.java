package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBConnector;

public class UserInsertDAO {

	public int InsertDAO(String user_name, String password, String birthDay) throws SQLException {
		
		DBConnector DBcon = new DBConnector();
		Connection con = DBcon.getConnection();
		
		String sql = "insert into users(user_name, password, admin_flg, birthDay) values(?,?,'',?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user_name);
		ps.setString(2, password);
		//admin_flg(管理者権限かどうか確認するためのcolumn)には空文字を入れておく（NULL回避)
		ps.setString(3, birthDay);
		
		int i = ps.executeUpdate();
		
		con.close();
		return i;
	}
	
}
