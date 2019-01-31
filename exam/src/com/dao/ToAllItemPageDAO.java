package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.LoginActionDTO;
import com.util.DBConnector;
public class ToAllItemPageDAO {
	
	//宣言たち
	DBConnector DBcon = new DBConnector();
	//オブジェクトを入れるならnewが必要
	private ArrayList<LoginActionDTO> AllItemList = new ArrayList<LoginActionDTO>();
	int i = 0;

	public ArrayList<LoginActionDTO> getAllItem() {
		Connection con = DBcon.getConnection();
		String sql ="select * from items";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			//while文通ってない
			while ( rs.next() ) {
				LoginActionDTO DTO = new LoginActionDTO();
				DTO.setId_number(rs.getInt("id_number"));
				DTO.setBuyItemName(rs.getString("buyItemName"));
				DTO.setBuyItemPrice(rs.getInt("buyItemPrice"));
				DTO.setItemCategory(rs.getString("Category"));
				AllItemList.add(DTO);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return AllItemList;
	}
}
