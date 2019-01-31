package com.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.SortDAO;
import com.dto.LoginActionDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {

	private String result;
	public Map<String, Object> session;
	private SortDAO SORT = new SortDAO();
	public ArrayList<LoginActionDTO> userBuyItemInfoList = new ArrayList<LoginActionDTO>();
	
	public String first()  {

		
		if ( session.containsKey("loginFLG") ) {
			result = SUCCESS;
		} else {
			result = LOGIN;
		}
		userBuyItemInfoList = SORT.SortByDateASC((int)session.get("userId_number"));
		
		return result;
	}


	public ArrayList<LoginActionDTO> getUserBuyItemInfoList() {
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
