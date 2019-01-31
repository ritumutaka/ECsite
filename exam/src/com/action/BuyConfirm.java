package com.action;

import java.text.NumberFormat;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyConfirm extends ActionSupport implements SessionAware {

	//宣言たち
	public Map<String, Object> session;
	private String result;
	private int buyCount;
	private String total_price;
	NumberFormat NF = NumberFormat.getCurrencyInstance();
	
	public String calculate() {
		result = SUCCESS;
		
		//購入する個数を取得して合計金額を算出
		total_price = NF.format(Integer.parseInt((String)session.get("buyItemPrice")) * buyCount);
		
		//次の確認画面で表示するためにsessionにput
		session.put("buyCount", buyCount);
		session.put("total_price", total_price);
		
		return result;
	}
	
	
	//宣言たち
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}
}
