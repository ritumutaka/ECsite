package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.LoginActionDTO;
import com.util.DBConnector;


public class CategoryDAO {

	//戻り値は選択されたカテゴリーの商品情報が入ったリスト
	public ArrayList<LoginActionDTO> getCategory(int category) {
		ArrayList<LoginActionDTO> L = new ArrayList<LoginActionDTO>();
		DBConnector DBcon = new DBConnector();
		Connection con = DBcon.getConnection();
		String sql = "select * from items where Category = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, category);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				LoginActionDTO DTO = new LoginActionDTO();
				DTO.setCategory(rs.getString("Category"));
				DTO.setBuyItemName(rs.getString("buyItemName"));
				DTO.setBuyItemPrice(rs.getInt("buyItemPrice"));
				DTO.setId_number(rs.getInt("id_number"));
				L.add(DTO);
			}
			
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return L;
	}
}
