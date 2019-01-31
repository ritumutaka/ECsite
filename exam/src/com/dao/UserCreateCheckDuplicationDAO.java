package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBConnector;

public class UserCreateCheckDuplicationDAO {

	private String sql;
	private int check;
	
	public int checkDuplication(String name) {
	
		//DBに接続　DBConnector のフィールド値を使ってgetConnection();
		DBConnector DBcon = new DBConnector();
		Connection con = DBcon.getConnection();
		
		
		//sql文
		sql = "select * from users where user_name=?";
		
		//sql文を実際に実行して(被りチェック)
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				check++;
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return check;
		
	}
}
