package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.LoginActionDTO;
import com.util.DBConnector;

public class SortDAO {

	//宣言たち
	DBConnector DBcon = new DBConnector();
	ArrayList<LoginActionDTO> userBuyItemInfoList = new ArrayList<LoginActionDTO>();
	
	//case c
	//並び替え　価格の安い順
	public ArrayList<LoginActionDTO> SortByTotal_priceASC(int buyUserIdNumber) {
		//結合して2テーブルから取得
		String sql = "select * from user_buy_items "
				+ "inner join items "
				+ "on user_buy_items.buyItemName = items.buyItemName "
				+ "where buyUserIdNumber=? "
				+ "order by total_price ASC";
		try {
			Connection con = DBcon.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, buyUserIdNumber);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				LoginActionDTO dto = new LoginActionDTO();
				dto.setBuyItemName(rs.getString("buyItemName"));
				dto.setBuyItemPrice(rs.getInt("buyItemPrice"));
				dto.setBuyCount(rs.getInt("buyCount"));
				dto.setTotal_price(rs.getInt("total_price"));
				dto.setBuyDate(rs.getString("buyDate"));
				userBuyItemInfoList.add(dto);
			}
			
			con.close();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		
		return userBuyItemInfoList;			
	}
	
	//case d
	//並び替え　価格の高い順
	public ArrayList<LoginActionDTO> SortByTotal_priceDESC(int buyUserIdNumber) {
		//結合して2テーブルから取得
		String sql = "select * from user_buy_items "
				+ "inner join items "
				+ "on user_buy_items.buyItemName = items.buyItemName "
				+ "where buyUserIdNumber=? "
				+ "order by total_price DESC";
		try {
			Connection con = DBcon.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, buyUserIdNumber);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				LoginActionDTO dto = new LoginActionDTO();
				dto.setBuyItemName(rs.getString("buyItemName"));
				dto.setBuyItemPrice(rs.getInt("buyItemPrice"));
				dto.setBuyCount(rs.getInt("buyCount"));
				dto.setTotal_price(rs.getInt("total_price"));
				dto.setBuyDate(rs.getString("buyDate"));
				userBuyItemInfoList.add(dto);
			}
			
			con.close();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		
		return userBuyItemInfoList;			
	}
	
	
	
	//case a
	//並び替え　日付の古い順
	public ArrayList<LoginActionDTO> SortByDateASC(int buyUserIdNumber) {
		//結合して2テーブルから取得
		String sql = "select * from user_buy_items "
				+ "inner join items "
				+ "on user_buy_items.buyItemName = items.buyItemName "
				+ "where buyUserIdNumber=? "
				+ "order by buyDate ASC";
		try {
			Connection con = DBcon.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, buyUserIdNumber);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				LoginActionDTO dto = new LoginActionDTO();
				dto.setBuyItemName(rs.getString("buyItemName"));
				dto.setBuyItemPrice(rs.getInt("buyItemPrice"));
				dto.setBuyCount(rs.getInt("buyCount"));
				dto.setTotal_price(rs.getInt("total_price"));
				dto.setBuyDate(rs.getString("buyDate"));
				userBuyItemInfoList.add(dto);
			}
			
			con.close();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		
		return userBuyItemInfoList;			
	}
	
	//case a
	//並び替え　日付の古い順
	public ArrayList<LoginActionDTO> SortByDateDESC(int buyUserIdNumber) {
		//結合して2テーブルから取得
		String sql = "select * from user_buy_items "
				+ "inner join items "
				+ "on user_buy_items.buyItemName = items.buyItemName "
				+ "where buyUserIdNumber=? "
				+ "order by buyDate DESC";
		try {
			Connection con = DBcon.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, buyUserIdNumber);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				LoginActionDTO dto = new LoginActionDTO();
				dto.setBuyItemName(rs.getString("buyItemName"));
				dto.setBuyItemPrice(rs.getInt("buyItemPrice"));
				dto.setBuyCount(rs.getInt("buyCount"));
				dto.setTotal_price(rs.getInt("total_price"));
				dto.setBuyDate(rs.getString("buyDate"));
				userBuyItemInfoList.add(dto);
			}
			
			con.close();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		
		return userBuyItemInfoList;			
	}
	
}
