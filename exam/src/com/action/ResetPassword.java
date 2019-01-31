package com.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.util.DBConnector;
public class ResetPassword extends ActionSupport implements SessionAware {

	private int year;
	private int month;
	private int day;
	private Map<String, Object> session;
	private String result;
	private String oldPassword;
	private String newPassword;
	private DBConnector DBcon = new DBConnector();
	
	public String execute() {
		
		Identification();
		
		if(result.equals(SUCCESS)) {
			
		}
		
		return result;
	}
	
	
	
	//DBで確認(DAOをここに書いた)
	public void Identification() {
		UserCreateCheckDuplication a = new UserCreateCheckDuplication();
		String sql = "select * from users where user_name=? and password=? and birthDay=?";
		String sql2 = "update users set password=? where id_number=?";
		Connection con = DBcon.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, (String)session.get("user_name"));
			ps.setString(2, oldPassword);
			ps.setString(3, a.getCal(year, month, day));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				result = SUCCESS;
				PreparedStatement ps2= con.prepareStatement(sql2);
				ps2.setString(1, newPassword);
				ps2.setInt(2, rs.getInt("id_number"));
				ps2.execute();
			} else {
				result = ERROR;
				System.out.println("入力内容に誤りがあります。");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public int getYear() {
		return this.year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getMonth() {
		return this.month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getDay() {
		return this.day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	public String getOldPassword() {
		return this.oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
	public String getNewPassword() {
		return this.newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return this.session;
	}
	
}
