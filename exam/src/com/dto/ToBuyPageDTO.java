package com.dto;

public class ToBuyPageDTO {

	private int id_number;
	private String buyItemName;
	private int buyItemPrice;
	
	public void setId_number(int id_number) {
		this.id_number = id_number;
	}
	public int getBuyId_number() {
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
	
	
}
