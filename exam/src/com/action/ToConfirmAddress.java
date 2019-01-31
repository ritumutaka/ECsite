package com.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dto.LoginActionDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ToConfirmAddress extends ActionSupport implements SessionAware {

	//宣言たち
	private String YourName;
	private String YourCountry;
	private String YourState;
	private String YourContact;
	private String result;
	public Map<String, Object> session;
	private int addressSelectNumber;
	private ArrayList<LoginActionDTO> L = new ArrayList<LoginActionDTO>();
	private AddressCheck A = new AddressCheck();
	
	public String confirmAddress() {
		
		/*jspでインクリメントされているのでデクリメント*/
		addressSelectNumber --;
		
		if(addressSelectNumber < 0) {
			
			//入力フォームに一つも穴がなければ、SUCCESSを返し、sessionに入力した情報をput
			if ( !( YourName.isEmpty() || YourCountry.isEmpty() || YourState.isEmpty() || YourContact.isEmpty()) ) {
				//すでにログインしていればtrue 
				if( session.get("loginFLG") != null ) {
					result = SUCCESS;
					
					session.put("YourName", YourName);
					session.put("YourCountry", YourCountry);
					session.put("YourState", YourState);
					session.put("YourContact", YourContact);
					
				} else {
					result = LOGIN;
				}
				
			//入力フォームに一つでも穴があれば、ERRORを返す
			} else {
				result = ERROR;
				System.out.println("入力されていない項目があります。");
			}
		} else {
			L = A.getAddress((int)session.get("userId_number"));
			session.put("YourCountry", L.get(addressSelectNumber).getCountry());
			session.put("YourState", L.get(addressSelectNumber).getState());
			session.put("YourContact", L.get(addressSelectNumber).getContact());
			result = SUCCESS;
		}
		
		return result;
	}
	
	

	public ArrayList<LoginActionDTO> getL () {
		return this.L;
	}
	public void setL(ArrayList<LoginActionDTO> L) {
		this.L = L;
	}
	
	public void setAddressSelectNumber(int addressSelectNumber) {
		this.addressSelectNumber = addressSelectNumber;
	}
	public int getAddressSelectNumber() {
		return addressSelectNumber;
	}
	
	public void setYourName(String YourName) {
		this.YourName = YourName;
	}
	public String getYourName() {
		return YourName;
	}
	
	public void setYourCountry(String YourCountry) {
		this.YourCountry = YourCountry;
	}
	public String getYourCountry() {
		return YourCountry;
	}
	
	public void setYourState(String YourState) {
		this.YourState = YourState;
	}
	public String getYourState() {
		return YourState;
	}
	
	public void setYourContact(String YourContact) {
		this.YourContact = YourContact;
	}
	public String getYourContact() {
		return YourContact;
	}
	
	
	
	@Override 
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	
	
}
