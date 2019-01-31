package com.action;

import com.dao.ItemAddDAO;
import com.opensymphony.xwork2.ActionSupport;
public class UserAdd extends ActionSupport {

	private String result;
	private int insert_number;
	private String AddUserName;
	private String AddUserPassword;
	private ItemAddDAO ADD = new ItemAddDAO();
	
	public String execute() {
		
			insert_number = ADD.Insert(AddUserName, AddUserPassword);
			
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
	
	public void setAddUserName(String AddUserName) {
		this.AddUserName = AddUserName;
	}
	public String getAddUserName() {
		return AddUserName;
	}
	
	public void setAddUserPassword(String AddUserPassword) {
		this.AddUserPassword = AddUserPassword;
	}
	public String getAddUserPassword() {
		return AddUserPassword;
	}
}
