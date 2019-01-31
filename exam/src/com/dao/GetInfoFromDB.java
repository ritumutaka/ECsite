package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.LoginActionDTO;
import com.util.DBConnector;

public class GetInfoFromDB {
	
	//このクラスで使える宣言たち
	DBConnector DBcon = new DBConnector();
	ArrayList<LoginActionDTO> L = new ArrayList<LoginActionDTO>();
	
	
	//ArrayList[DTO,DTO,DTO,・・・]で返す
	//(テーブル名, 引数)
	//商品名で検索(items, buyItemName)
		public ArrayList<LoginActionDTO> getItemInfoByName(String Item_Name) {
			Connection con = DBcon.getConnection();
			
			String sql = "select * from items where buyItemName=?";
			
			try {
				PreparedStatement ps = con.prepareCall(sql);
				ps.setString(1, Item_Name);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					LoginActionDTO DTO = new LoginActionDTO();
					DTO.setBuyItemName(rs.getString("id_number"));
					DTO.setBuyItemPrice(rs.getInt("buyItemPrice"));
					L.add(DTO);
				}
				
			} catch ( SQLException e ) {
				e.printStackTrace();
			}
			return L;
		}
	
	
	//商品のid_numberで検索 (items, id_number)
	public ArrayList<LoginActionDTO> getItemInfoByNumber(int Item_id_number) {
		Connection con = DBcon.getConnection();
		
		String sql = "select * from items where id_number=?";
		
		try {
			PreparedStatement ps = con.prepareCall(sql);
			ps.setInt(1, Item_id_number);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				LoginActionDTO DTO = new LoginActionDTO();
				DTO.setId_number(rs.getInt("id_number"));
				DTO.setBuyItemName(rs.getString("buyItemName"));
				DTO.setBuyItemPrice(rs.getInt("buyItemPrice"));
				DTO.setCategory(rs.getString("Category"));
				DTO.setImagePath(rs.getString("imagePath"));
				DTO.setDiscription(rs.getString("discription"));
				L.add(DTO);
			}
			
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return L;
	}
}
