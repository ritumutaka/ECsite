package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class UserCreateCompleteDAO {

	//忘れ物３　DBconインスタンスを使って、getConnection()すること
	private DBConnector DBcon = new DBConnector();
	private Connection con = DBcon.getConnection();

	//忘れ物１
	private DateUtil dateUtil = new DateUtil();
	//忘れ物２　insert文が違う
	/*String sql = "insert into login_user_transaction where login_id = ? and login_pass = ? and user_name = ?";*/
	String sql = "insert into login_user_transaction(login_id, login_pass, user_name, insert_date) values(?,?,?,?)";


	public void createUser(String loginUserId, String loginPassword, String userName) throws SQLException {


		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);
			ps.setString(3, userName);
			//忘れ物1
			ps.setString(4,dateUtil.getDate());


			ps.execute();

			System.out.println(ps);

		} catch (Exception e ) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
}
