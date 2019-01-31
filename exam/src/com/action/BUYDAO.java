package com.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.LoginActionDTO;
import com.util.DBConnector;
import com.util.DateUtil;
public class BUYDAO {

	DBConnector DBcon = new DBConnector();
	DateUtil D = new DateUtil();
	//単体購入
	public int insertUesrBuyItems(int buyUserIdNumber, String buyItemName, int buyCount, int total_price ) {
		
	String sql = "insert into user_buy_items(buyUserIdNumber, buyItemName, buyCount, total_price, buyDate) values(?,?,?,?,?) ";
	Connection con = DBcon.getConnection();
	int rs = 0;
	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, buyUserIdNumber);
			ps.setString(2, buyItemName);
			ps.setInt(3, buyCount);
			ps.setInt(4, total_price);
			ps.setString(5, D.getDate());
			rs = ps.executeUpdate();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	//カート内全購入
	public ArrayList<LoginActionDTO> buyAllInCart(int addUserIdNumber) {
		ArrayList<LoginActionDTO> A = new ArrayList<LoginActionDTO>();
		String sql = "select * from cart where addUserIdNumber=?";
		String sql2 = "delete from cart where addUserIdNumber=?";
		String sql3 = "insert into user_buy_items(buyUserIdNumber, buyItemName, buyCount, total_price, buyDate) values(?,?,?,?,?)";

		try {
			Connection con = DBcon.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, addUserIdNumber);
			ResultSet rs = ps.executeQuery();
			
			//cartテーブルから取得、user_buy_itemsテーブルへ追加
			while( rs.next() ) {
				LoginActionDTO L = new LoginActionDTO();
				L.setId_number(rs.getInt("addUserIdNumber"));
				L.setBuyItemName(rs.getString("ItemName"));
				L.setBuyItemPrice(rs.getInt("ItemPrice"));
				L.setBuyCount(rs.getInt("Count"));
				L.setTotal_price(rs.getInt("total_price"));
				A.add(L);
				PreparedStatement ps3 = con.prepareStatement(sql3);
				ps3.setInt(1, rs.getInt("addUserIdNumber"));
				ps3.setString(2, rs.getString("ItemName"));
				ps3.setInt(3, rs.getInt("Count"));
				ps3.setInt(4, rs.getInt("total_price"));
				ps3.setString(5, D.getDate());
				ps3.execute();
			}
			//cartテーブルから削除
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setInt(1, addUserIdNumber);
			ps2.execute();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return A;
	}
	
	
	//カート内に商品があるかチェック
	public ArrayList<LoginActionDTO> checkCart(int userIdNumber) {
		ArrayList<LoginActionDTO> L = new ArrayList<LoginActionDTO>();
		Connection con = DBcon.getConnection();
		String sql = "select * from cart where addUserIdNumber=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userIdNumber);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				LoginActionDTO dto = new LoginActionDTO();
				dto.setBuyItemName(rs.getString("ItemName"));
				dto.setBuyItemPrice(rs.getInt("ItemPrice"));
				dto.setBuyCount(rs.getInt("Count"));
				dto.setTotal_price(rs.getInt("total_price"));
				dto.setBuyDate(rs.getString("addDate"));
				L.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return L;
	}
	
}
