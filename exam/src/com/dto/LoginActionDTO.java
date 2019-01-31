package com.dto;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class LoginActionDTO implements SessionAware {

	private Map<String, Object> session;
	private int id_number;
	private String user_name;
	private String password;
	private String buyItemName;
	private int total_price;
	private int buyCount;
	private int buyItemPrice;
	private String admin_flg;
	private String category;
	private String buyDate;
	private String ItemCategory;
	private String birthDay;
	private String Country;
	private String State;
	private String Contact;
	private int check;
	private String imagePath;
	private String discription;
	
	private String AAAA;
	private int BBBB;
	
	//Aは使ってない
	public String getAAAA() {
		return this.AAAA;
	}
	public void setAAAA(String AAAA) {
		this.AAAA = AAAA;
	}
	//Bも使ってない
	public int getBBBB() {
		return this.BBBB;
	}
	public void setBBBB(int BBBB) {
		this.BBBB = BBBB;
	}
	
	
	
	public String getDiscription() {
		return this.discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	public String getImagePath() {
		return this.imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public int getCheck() {
		return this.check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	
	public String getContact() {
		return this.Contact;
	}
	public void setContact(String Contact) {
		this.Contact = Contact;
	}
	
	public String getState() {
		return this.State;
	}
	public void setState(String State) {
		this.State = State;
	}
	
	public String getCountry() {
		return this.Country;
	}
	public void setCountry(String Country) {
		this.Country = Country;
	}
	
	public String getBirthDay() {
		return this.birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	
	public String getItemCategory() {
		return this.ItemCategory;
	}
	public void setItemCategory(String ItemCategory) {
		this.ItemCategory = ItemCategory;
	}
	
	public String getBuyDate() {
		return this.buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	
	
	public String getCategory() {
		return this.category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getAdmin_flg() {
		return this.admin_flg;
	}
	public void setAdmin_flg(String admin_flg) {
		this.admin_flg = admin_flg;
	}
	
	
	public int getBuyItemPrice() {
		return this.buyItemPrice;
	}
	public void setBuyItemPrice(int buyItemPrice) {
		this.buyItemPrice = buyItemPrice;
	}
	
	public int getBuyCount() {
		return this.buyCount;
	}
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	
	public String getBuyItemName() {
		return this.buyItemName;
	}
	public void setBuyItemName(String buyItemName) {
		this.buyItemName = buyItemName;
	}

	public int getTotal_price() {
		return this.total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	
	public int getId_number() {
		return this.id_number;
	}
	public void setId_number(int id_number) {
		this.id_number = id_number;
	}
	
	public String getUser_name() {
		return this.user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return this.session;
	}
	
	
}
