package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class LoginDAO {

	private DBConnector dbCon = new DBConnector();
	private Connection con = dbCon.getConnection();
	private LoginDTO loginDTO = new LoginDTO();

	//ログイン情報をloginDTO（オブジェクト）に入れて返す
	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) {
		String sql = "select * from login_user_transaction where login_id = ? and login_pass = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				loginDTO.setLoginUserId(rs.getString("login_id"));
				loginDTO.setLoginPassword(rs.getString("login_pass"));
				loginDTO.setUserName(rs.getString("user_name"));
				loginDTO.setId(rs.getInt("id"));

				if(!(rs.getString("login_id").equals(null))) {
					loginDTO.setLoginFlg(true);
				}
			}

		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return loginDTO;
	}


	public LoginDTO getLoginDTO() {
		return loginDTO;
	}
}
