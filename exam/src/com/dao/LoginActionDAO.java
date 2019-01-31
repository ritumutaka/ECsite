package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dto.LoginActionDTO;
import com.util.DBConnector;

public class LoginActionDAO implements SessionAware {

	private DBConnector DBcon = new DBConnector();
	public Map<String, Object> session;
	private ArrayList<LoginActionDTO> userBuyItemInfoList = new ArrayList<LoginActionDTO>();

	public LoginActionDTO getUserInfo(String user_name, String password) {
		//宣言たち
		LoginActionDTO loginL = new LoginActionDTO();
		String sql = "select * from users where user_name = ? and password = ?";
		Connection con = DBcon.getConnection();

		try {
			PreparedStatement ps =  con.prepareStatement(sql);
			ps.setString(1, user_name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				loginL.setId_number(rs.getInt("id_number"));
				loginL.setUser_name(rs.getString("user_name"));
				loginL.setPassword(rs.getString("password"));
				loginL.setAdmin_flg(rs.getString("admin_flg"));
				loginL.setBirthDay(rs.getString("birthDay"));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return loginL;
	}
	
	
	//ユーザー情報を引き出して返す 
	//引：int型　sessionからユーザーIDを渡してあげればよい
	//戻：オブジェクト　ユーザーID、名前、パスワード込
	public LoginActionDTO getUserInfo2(int userId_number) {
		//sessionにuserId_numberだけ入れておいてテーブルから情報を引き出す
		LoginActionDTO loginL = new LoginActionDTO();
		String sql2 = "select * from users where id_number = ?";
		
		try {
			Connection con = DBcon.getConnection();
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setInt(1, userId_number);
			ResultSet rs2 = ps2.executeQuery();
			
		//今のユーザー情報をloginLにset
			if ( rs2.next() ) {
				loginL.setId_number(rs2.getInt("id_number"));
				loginL.setUser_name(rs2.getString("user_name"));
				loginL.setPassword(rs2.getString("password"));
			}
			
			con.close();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		
		//ユーザー情報の入ったオブジェクトを返す
		return loginL;
	}
	
	
	//ユーザーの購入履歴を取得
	public ArrayList<LoginActionDTO> getBuyItems(int buyUserIdNumber) {
		String sql3 = "select * from user_buy_items where buyUserIdNumber=?";
		Connection con = DBcon.getConnection();
		try {
			PreparedStatement ps3 = con.prepareStatement(sql3);
			ps3.setInt(1, buyUserIdNumber);
			ResultSet rs3 = ps3.executeQuery();
			
			//買ったものが２つ以上あった場合、それぞれbuyItemInfoListへaddしていく
			while( rs3.next() ) {
				LoginActionDTO LoginDTO = new LoginActionDTO();
				LoginDTO.setBuyItemName(rs3.getString("buyItemName"));
					//商品情報をitemsテーブルから取得
					String sql4 = "select * from items where buyItemName=?";
					PreparedStatement ps4 = con.prepareStatement(sql4);
					ps4.setString(1, rs3.getString("buyItemName"));
					ResultSet rs4 = ps4.executeQuery();
					rs4.next();
				LoginDTO.setBuyItemPrice(rs4.getInt("buyItemPrice"));
				LoginDTO.setBuyCount(rs3.getInt("buyCount"));
				LoginDTO.setTotal_price(rs3.getInt("total_price"));
				LoginDTO.setBuyDate(rs3.getString("buyDate"));
				userBuyItemInfoList.add(LoginDTO);
			}
			
			con.close();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return userBuyItemInfoList;			
	}
	
	

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return this.session;
	}
}
