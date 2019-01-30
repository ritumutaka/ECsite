package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	public String execute() {
		String result = "login";
		if ( session.containsKey("id")) {
			//BIDAOのメソッドを使いたいのでインスタンス化
			BuyItemDAO BIDAO = new BuyItemDAO();

			//getBuyItemInfo()でBIDTOのフィールド値を取得してBIDTO777へ入れる
			//同じ名前の方がわかりやすい（？）
			BuyItemDTO BIDTO777 = BIDAO.getBuyItemInfo();

			//ログインしていればsessionというMapにBIDTO777のフィールド値を入れる
			session.put("id",BIDTO777.getId());
			session.put("buyItem_name",BIDTO777.getItemName());
			session.put("buyItem_price",BIDTO777.getItemPrice());

			result = SUCCESS;
		}
		return result;
	}



	public Map<String, Object> getSession() {
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
