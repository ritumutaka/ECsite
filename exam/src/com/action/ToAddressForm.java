package com.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ToAddressForm extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	
	public String addressFrom() {
				
		return SUCCESS;
	}
	
	
	@Override 
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	
	
}
