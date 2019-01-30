package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

//DAO (Data Access Object)    DBに接続して、場合によっては結果をとってくるだけ
public class BuyItemConfirmDAO {

	/*private String id;
	private String login_user_id;
	private String total_price;
	private String count;
	private String pay;*/

	private DBConnector DBcon = new DBConnector();
	private Connection con = DBcon.getConnection();
	private DateUtil date = new DateUtil();

	public void buyItemInfo(String id, String userid, String total_price, String count, String pay) {
		String sql = "insert into user_buy_item_transaction(item_transaction_id, user_master_id, total_price, total_count, pay, insert_date) values(?,?,?,?,?,?)";
		try {

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, userid);
		ps.setString(3, total_price);
		ps.setString(4, count);
		//pay が文字化け
		ps.setString(5, pay);
		ps.setString(6, date.getDate());

		ps.execute();
		con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
