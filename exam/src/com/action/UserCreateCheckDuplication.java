package com.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.UserCreateCheckDuplicationDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCheckDuplication extends ActionSupport implements SessionAware {

	private String Cal;
	private int year;
	private int month;
	private int day;
	private String result;
	private String user_name;
	private String password;
	private int check;
	public Map<String,Object> session;
	private String birthDay;

	public String  checkDuplication() {

		result = SUCCESS;
		
//		テーブルに被りがあればその件数をcheckに入れる
		UserCreateCheckDuplicationDAO dao = new UserCreateCheckDuplicationDAO();
		check = dao.checkDuplication(user_name);
		
		if(check > 0) {
			result = ERROR;
			System.out.println("すでに使われているユーザー名です。");
		} else {
			session.put("user_name", user_name);
			session.put("password", password);
			result = SUCCESS;
			//year, month, day から日付を取得
			birthDay = getCal(year, month, day);
			session.put("birthDay",  birthDay);
		}
		
		return result;
	}
	
	
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	
	public String getBirthDay() {
		return this.birthDay;
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
	public void  setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
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
	
	public String getCal(int year, int month, int day) {
		Cal = String.valueOf(year) + "/" + String.valueOf(month) + "/" + String.valueOf(day);
		return Cal;
	}
}
