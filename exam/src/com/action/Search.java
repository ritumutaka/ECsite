package com.action;


import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.SearchDAO;
import com.dto.LoginActionDTO;
import com.opensymphony.xwork2.ActionSupport;

public class Search extends ActionSupport implements SessionAware {

	private int categoryId;
	private String keywords;
	private String[] SearchWords;
	private ArrayList<LoginActionDTO> L = new ArrayList<LoginActionDTO>();
	private Map<String, Object> session;
	
	public String execute() {
		SearchDAO S = new SearchDAO();
		if( keywords.contains("　") ){
			keywords.replaceAll("　", " ");
		}
		SearchWords = keywords.split(" ");
	
		//検索した内容をLへ
		L = S.checkCategory(categoryId, SearchWords);
		
		session.put("L", L);
		
		return SUCCESS;
	}
	
	public int getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getKeywords() {
		return this.keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public ArrayList<LoginActionDTO> getL() {
		return this.L;
	}
	public void setL(ArrayList<LoginActionDTO> L) {
		this.L = L;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	
}
