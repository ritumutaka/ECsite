package com.action;

import com.dao.ItemAddDAO;
import com.opensymphony.xwork2.ActionSupport;
public class ItemAdd extends ActionSupport {

	private String AddItemDiscription;
	private String AddItemCategory;
	private String result;
	private int insert_number;
	private String AddItemName;
	private int AddItemPrice = -1;
	private ItemAddDAO ADD = new ItemAddDAO();
	
	public String execute() {
		
		if ( AddItemPrice < 0) {
			result = ERROR;
		} else {
			insert_number = ADD.Insert(AddItemName, AddItemPrice, AddItemCategory, AddItemDiscription);
		}
		
		//Insertは追加した件数を返す
		
		if ( insert_number > 0 ) {
			result = SUCCESS;
			System.out.println( insert_number + "件追加しました。");
		} else {
			result = ERROR;
			System.out.println("追加できませんでした。");
		}
		
		return result;
	}
	
	
	
	
	public void setAddItemDiscription(String AddItemDiscription) {
		this.AddItemDiscription = AddItemDiscription;
	}
	public String getAddItemDiscription() {
		return AddItemDiscription;
	}
	
	public void setAddItemName(String AddItemName) {
		this.AddItemName = AddItemName;
	}
	public String getAddItemName() {
		return AddItemName;
	}
	
	public void setAddItemPrice(int AddItemPrice) {
		this.AddItemPrice = AddItemPrice;
	}
	public int getAddItemPrice() {
		return AddItemPrice;
	}
	
	public void setAddItemCategory(String AddItemCategory) {
		this.AddItemCategory = AddItemCategory;
	}
	public String getAddItemCategory() {
		return AddItemCategory;
	}
}
