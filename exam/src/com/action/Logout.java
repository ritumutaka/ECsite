package com.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Logout extends ActionSupport  implements SessionAware {

	public Map<String, Object> session;
	private String result;
	
	public String logout() {
		
		session.clear();
		if ( session.isEmpty() ) {
			result = SUCCESS;
		} else {
			result = ERROR;
		}
		
		return result;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return this.session;
	}
}
