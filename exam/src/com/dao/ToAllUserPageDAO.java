package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.LoginActionDTO;
import com.util.DBConnector;
public class ToAllUserPageDAO {
	
	//宣言たち
	DBConnector DBcon = new DBConnector();
	//オブジェクトを入れるならnewが必要
	private ArrayList<LoginActionDTO> AllUserList = new ArrayList<LoginActionDTO>();

	public ArrayList<LoginActionDTO> getAllUser() {
		Connection con = DBcon.getConnection();
		String sql ="select * from users";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				LoginActionDTO DTO = new LoginActionDTO();
				DTO.setId_number(rs.getInt("id_number"));
				DTO.setUser_name(rs.getString("user_name"));
				DTO.setPassword(rs.getString("password"));
				AllUserList.add(DTO);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return AllUserList;
	}
}
