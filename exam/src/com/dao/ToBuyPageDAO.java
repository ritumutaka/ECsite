package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.ToBuyPageDTO;
import com.util.DBConnector;

public class ToBuyPageDAO {

	public ArrayList<String> getBuyItemInfo(String buyItemName){
		
	String sql = "select * from items where buyItemName=?";
	ArrayList<String> BuyItemsInfo = new ArrayList<String>();
	ToBuyPageDTO TBPDTO = new ToBuyPageDTO();
	
	try {
		//購入したい商品の名前で検索して、idと価格を取得
		DBConnector DBcon = new DBConnector();
		Connection con = DBcon.getConnection();
		PreparedStatement ps =  con.prepareStatement(sql);
		ps.setString(1,buyItemName);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			BuyItemsInfo.add(rs.getString("id_number"));
			BuyItemsInfo.add(rs.getString("buyItemName"));
			BuyItemsInfo.add(rs.getString("buyItemPrice"));
			TBPDTO.setId_number(rs.getInt("id_number"));
			TBPDTO.setBuyItemName(rs.getString("buyItemName"));
			TBPDTO.setBuyItemPrice(rs.getInt("buyItemPrice"));
		}
		
		
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return BuyItemsInfo;
	
	}
}
