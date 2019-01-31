package com.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.UserInsertDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserInsert extends ActionSupport implements SessionAware {

	private String result;
	private int i;
	private String user_name;
	private String password;
	private UserInsertDAO insert = new UserInsertDAO();
	public Map<String, Object> session;
	private String birthDay;
	
	public String Insert() {
		result = ERROR;
		try {
			//sessionのuser_nameとpasswordをStringにキャストし、引数として渡す
			//iは登録した件数
			i = insert.InsertDAO(session.get("user_name").toString(),session.get("password").toString(),(String)session.get("birthDay"));
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		
		//登録したらSUCCESS;
		if( i > 0 ) {
			result = SUCCESS;
			session.put("birthDay", birthDay);
		} else {
			System.out.println("何らかの原因で登録できませんでした。");
		}
		return result;
	}
	
	
	public String getBirthDay() {
		return this.birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	
	//jspからsetterで受け取って（忘れたら入力内容を受け取れない！）
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_name() {
		return user_name;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	
}
