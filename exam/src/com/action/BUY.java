package com.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dto.LoginActionDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BUY extends ActionSupport implements SessionAware {
	//宣言たち
	Map<String, Object> session;
	private String buyItemName;
	private String errorMessage;
	ArrayList<LoginActionDTO> L = new ArrayList<LoginActionDTO>();
	
	//BUYを押した時点でユーザー購入情報をテーブルへinsert
	public String buy() {
		BUYDAO BUYDAO = new BUYDAO();
		if ( buyItemName.equals("buyAll"))  {
			//カート内に商品があるかチェック
			L = BUYDAO.checkCart((int)session.get("userId_number"));
			//商品があれば全購入
			if( L.size() > 0 ) {
				BUYDAO.buyAllInCart((int)session.get("userId_number"));
				errorMessage = "noProblem";
			} else {
				errorMessage = "noneItem";
			}
		} else {
			//単体購入 //今は単体購入ページ自体を削除しているのでできません。
			BUYDAO.insertUesrBuyItems((int)session.get("userId_number"), (String)session.get("buyItemName"), (int)session.get("buyCount"), (int)session.get("buyCount") * Integer.parseInt((String)session.get("buyItemPrice")));			
		}
		
	return SUCCESS;
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
	}
	
	public String getBuyItemName() {
		return this.buyItemName;
	}
	public void setBuyItemName(String buyItemName) {
		this.buyItemName = buyItemName;
	}
	
	@Override
	public void setSession(Map<String, Object> session ) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	
}
