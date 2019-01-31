package com.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.CartDAO;
import com.dao.LoginActionDAO;
import com.dto.LoginActionDTO;
import com.opensymphony.xwork2.ActionSupport;

public class Cart extends ActionSupport implements SessionAware {

	private int c;
	private int Count;
	private CartDAO C = new CartDAO();
	private String result;
	private Map<String, Object> session;
	public ArrayList<LoginActionDTO> userBuyItemInfoList = new ArrayList<LoginActionDTO>();
	LoginActionDAO Ldao = new LoginActionDAO();
	
	public String execute() {
		
		System.out.println(session);
		
		c = C.setCart((int)session.get("userId_number"), (int)session.get("id_number"), Count);
		if ( c > 0 ) {
			System.out.println(c + "件カートに追加しました");
			result = SUCCESS;
			userBuyItemInfoList = Ldao.getBuyItems((int)session.get("userId_number"));			
		} else {
			System.out.println("失敗しました");
			result = ERROR;
		}
		return result;
	}
	
	
	public void setCount(int Count) {
		this.Count = Count;
	}
	public int getCount() {
		return this.Count;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	
	//LoginActionのリストを返す
	public ArrayList<LoginActionDTO> getUserBuyItemInfoList() {
		return this.userBuyItemInfoList;
	}
	
	public void setUserBuyItemInfoList(ArrayList<LoginActionDTO> userBuyItemInfoList) {
		this.userBuyItemInfoList = userBuyItemInfoList;
	}
}
