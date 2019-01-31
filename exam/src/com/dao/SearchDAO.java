package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.LoginActionDTO;
import com.util.DBConnector;

public class SearchDAO {

	public ArrayList<LoginActionDTO> checkCategory(int categoryId, String[] SearchWords) {
		ArrayList<LoginActionDTO> L = new ArrayList<LoginActionDTO>();
		String sql = "select * from items where";
		DBConnector DBcon = new DBConnector();
		Connection con = DBcon.getConnection();
		boolean first = true;

		if(categoryId != 0) {
			sql += " Category=" + categoryId ;
			first = false;
		}
		for(String SearchWord : SearchWords ) {
			if(first) {
				sql += " buyItemName like '%" + SearchWord + "%' or discription like '%" + SearchWord + "%'";
				first = false;
			} else {
				sql += " and (buyItemName like '%" + SearchWord + "%' or discription like '%" + SearchWord + "%')";
			}
		}
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				LoginActionDTO dto = new LoginActionDTO();
				dto.setId_number(rs.getInt("id_number"));
				dto.setBuyItemName(rs.getString("buyItemName"));
				dto.setBuyItemPrice(rs.getInt("buyItemPrice"));
				dto.setImagePath(rs.getString("imagePath"));
				L.add(dto);
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return L;
	}
	
	
}
