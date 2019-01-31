package com.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Category extends ActionSupport implements SessionAware {
	
	private int category;
	private String categoryName;
	private Map<String,Object>session;
	
	public String execute() {
		
		System.out.println(category);
		
		switch(category) {
		case 1:
			categoryName = "パソコン";
			break;
		case 2:
			categoryName = "机";
			break;
		case 3:
			categoryName = "椅子";
			break;
		}
		
		return SUCCESS;
	}
	
	
	public String getCategoryName() {
		return this.categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public int getCategory() {
		return this.category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public Map<String, Object> getSession() {
		return this.session;
	}
	
}
