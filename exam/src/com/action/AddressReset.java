package com.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.AddressResetDAO;
import com.opensymphony.xwork2.ActionSupport;

public class AddressReset extends ActionSupport implements SessionAware {

	private String Contact;
	private String State;
	private String Country;
	private String result;
	private AddressResetDAO A = new AddressResetDAO();
	private Map<String, Object> session;
	
	public String execute(){
		
		if( !( Contact.isEmpty() || State.isEmpty() || State.isEmpty())) {
			A.addAddress((int)session.get("userId_number"), Country, State, Contact);
			result = SUCCESS;
		} else {
			System.out.println("空欄があります。");
			result = ERROR;
		}
		
		return result;
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
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return this.session;
	}
}
