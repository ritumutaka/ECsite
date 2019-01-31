package com.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.SortDAO;
import com.dto.LoginActionDTO;
import com.opensymphony.xwork2.ActionSupport;

public class Sort extends ActionSupport implements SessionAware {

	//宣言たち
	private String result;
	private String sort = "a";
	private Map<String, Object> session;
	private SortDAO SORT = new SortDAO();
	public ArrayList<LoginActionDTO> userBuyItemInfoList = new ArrayList<LoginActionDTO>();
	
	public String execute() {
		
			if ( session.containsKey("loginFLG") ) {
					switch(sort) {
					case "a":
						userBuyItemInfoList = SORT.SortByDateASC((int)session.get("userId_number"));
						break;
					case "b":
						userBuyItemInfoList = SORT.SortByDateDESC((int)session.get("userId_number"));
						break;
					case "c":
						userBuyItemInfoList = SORT.SortByTotal_priceASC((int)session.get("userId_number"));
						break;
					case "d":
						userBuyItemInfoList = SORT.SortByTotal_priceDESC((int)session.get("userId_number"));
						break;
					}
					
					result = SUCCESS;
			} else {
				result = LOGIN;
			}
		return result;
	}
	
	//セッターゲッター
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getSort() {
		return this.sort;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return this.session;
	}
	
	//jsp用
	//<s:property value="userBuyItemInfoList"/>で参照可能
	public ArrayList<LoginActionDTO> getUserBuyItemInfoList() {
		return userBuyItemInfoList;
	}
	
}
