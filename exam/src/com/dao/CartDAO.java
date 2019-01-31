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
import com.util.DateUtil;

public class CartDAO implements SessionAware {

	Map<String, Object> session;
	DBConnector DBcon = new DBConnector();
	GetInfoFromDB G = new GetInfoFromDB();
	ArrayList<LoginActionDTO> L = new ArrayList<LoginActionDTO>();
	DateUtil D = new DateUtil();
	private int Item_id_number;
	
	//カートへ追加
	public int setCart(int user_id_number ,int Item_id_number, int Count) {
		int c = 0;
		Connection con = DBcon.getConnection();
		String sql = "insert into cart(addUserIdNumber, ItemName, ItemPrice, Count, addDate, total_price) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,user_id_number);
			ps.setString(2, G.getItemInfoByNumber(Item_id_number).get(0).getBuyItemName());
			ps.setInt(3, G.getItemInfoByNumber(Item_id_number).get(0).getBuyItemPrice());
			ps.setInt(4, Count);
			ps.setString(5,D.getDate());
			ps.setInt(6, G.getItemInfoByNumber(Item_id_number).get(0).getBuyItemPrice() * Count);
			c = ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	//カートから取り出し
	public ArrayList<LoginActionDTO> getCart(int id_number) {
		Connection con = DBcon.getConnection();
		String sql = "select * from cart where addUserIdNumber=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id_number);
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				LoginActionDTO DTO = new LoginActionDTO();
				DTO.setId_number(rs.getInt("number"));
				DTO.setBuyItemName(rs.getString("ItemName"));
				DTO.setBuyItemPrice(rs.getInt("ItemPrice"));
				DTO.setBuyCount(rs.getInt("Count"));
				DTO.setTotal_price(rs.getInt("total_price"));
				DTO.setBuyDate(rs.getString("addDate"));
				L.add(DTO);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return L;
	}
	
	
	public void Item_id_number(int Item_id_number) {
		this.Item_id_number = Item_id_number;
	}
	public int Item_id_number() {
		return Item_id_number;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}
}
