package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private BuyItemConfirmDAO BICDAO = new BuyItemConfirmDAO();


	public String execute() throws SQLException {
		BICDAO.buyItemInfo(
					session.get("id").toString(),
					session.get("userid").toString(),
					session.get("total_price").toString(),
					session.get("count").toString(),
					session.get("pay").toString());
		String result = SUCCESS;
		return result;
	}

	//セッションフィールドのsetter
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
