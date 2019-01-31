package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.util.DBConnector;

public class DeleteCart extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private int cartItemNumber;
	private int d;
	private String result;
	private DBConnector DBcon = new DBConnector();
	public String execute() {
		
		if(cartItemNumber > 0) {
			Connection con = DBcon.getConnection();
			String sql ="delete from cart where number = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, cartItemNumber);
				d = ps.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			Connection con = DBcon.getConnection();
			String sql = "delete from cart where addUserIdNumber=?";
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, (int)session.get("userId_number"));
				d = ps.executeUpdate();
			} catch ( SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		if(d > 0) {
			result = SUCCESS;
			System.out.println(d + "件削除しました");
		} else {
			result = ERROR;
			System.out.println("すでに削除されている商品です。");
		}
		return result;
	}
	
	public int getCartItemNumber() {
		return this.cartItemNumber;
	}
	public void setCartItemNumber(int cartItemNumber) {
		this.cartItemNumber = cartItemNumber;
	}
	
	
	public Map<String, Object> getSession() {
		return this.session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
