package com.action;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.GetInfoFromDB;
import com.dto.LoginActionDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ToBuyPage extends ActionSupport implements SessionAware {

	private String result;
	private String buyItemName;
	private int buyItemPrice;
	private int id_number;
	public Map<String, Object> session;
	NumberFormat NF = NumberFormat.getCurrencyInstance();
	
	public String buy() {
		System.out.println(session);
		System.out.println(id_number);
		//宣言たち
		result = SUCCESS;
		GetInfoFromDB G = new GetInfoFromDB();
		ArrayList<LoginActionDTO> BuyItemsInfoList = new ArrayList<LoginActionDTO>();
		
		//DAO→List  DAOで購入したい商品の情報を取得して代入(名前で検索)
		BuyItemsInfoList = G.getItemInfoByNumber(id_number);
		//session（購入したい商品の情報を取得して代入）
		session.put("id_number",BuyItemsInfoList.get(0).getId_number());
		session.put("buyItemName",BuyItemsInfoList.get(0).getBuyItemName());
		session.put("buyItemPrice",BuyItemsInfoList.get(0).getBuyItemPrice());
		session.put("Category", BuyItemsInfoList.get(0).getCategory());
		session.put("discription", BuyItemsInfoList.get(0).getDiscription());
		return result;
	}
	
	public void setId_number(int id_number) {
		this.id_number = id_number;
	}
	public int getId_number() {
		return id_number;
	}
	
	public void setBuyItemName(String buyItemName) {
		this.buyItemName = buyItemName;
	}
	public String getBuyItemName() {
		return buyItemName;
	}
	
	public void setBuyItemPrice(int buyItemPrice) {
		this.buyItemPrice = buyItemPrice;
	}
	public int getBuyItemPrice() {
		return buyItemPrice;
	}
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}
}
