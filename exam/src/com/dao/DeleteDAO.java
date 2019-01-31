package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.util.DBConnector;

public class DeleteDAO extends ActionSupport implements SessionAware {
	//宣言たち
	DBConnector DBcon = new DBConnector();
	Map<String, Object> session;
	
	
	public String execute() {
		delete((int)session.get("userId_number"));
		return SUCCESS;
	}
	
	
	public void delete(int userId_number) {
		String sql = "delete from user_buy_items where buyUserIdNumber = ?";
		Connection con = DBcon.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId_number);
			ps.executeUpdate();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}
	
	
	
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
