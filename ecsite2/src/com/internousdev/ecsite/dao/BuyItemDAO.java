package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {

	private DBConnector dbCon = new DBConnector();
	private Connection con = dbCon.getConnection();
	private BuyItemDTO BIDTO = new BuyItemDTO();

	//getBuyItemInfo()はテーブルから購入商品のid, item_name, item_price の値をとってきてBIDTOへセット
	public BuyItemDTO getBuyItemInfo() {
		String sql = "select id, item_name, item_price from item_info_transaction";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				BIDTO.setId(rs.getInt("id"));
				BIDTO.setItemName(rs.getString("item_name"));
				BIDTO.setItemPrice(rs.getString("item_price"));
			}

		} catch ( Exception e) {
			e.printStackTrace();
		}

		return BIDTO;
	}


	//getBuyItemDTO()は今できているBIDTOをそのまま返すだけ
	public BuyItemDTO getBuyItemDTO() {
		return BIDTO;
	}
}
