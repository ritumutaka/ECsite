package com.internousdev.ecsite.dto;

public class LoginDTO {

	private int Id;
	private int loginId;
	private String loginUserId;
	private String loginPassword;
	private String userName;
	private boolean loginFlg;
	
	public int getId() {
		return Id;
	}
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean getLoginFlg() {
		return loginFlg;
	}
	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}
	
	
}
