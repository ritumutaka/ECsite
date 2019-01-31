package com.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dto.LoginActionDTO;
import com.opensymphony.xwork2.ActionSupport;
import com.util.DBConnector;

public class AddressCheck extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String Contact;
	private String State;
	private String Country;
	private int check;
	private ArrayList<LoginActionDTO>dto = new ArrayList<LoginActionDTO>();
	
	public String execute() {

		return SUCCESS;
	}
	
	public ArrayList<LoginActionDTO> getAddress(int a) {
		DBConnector DBcon = new DBConnector();
		Connection con = DBcon.getConnection();
		String sql ="select * from address where UserIdNumber=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, a);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				LoginActionDTO L = new LoginActionDTO();
				L.setId_number(a);
				L.setCountry(rs.getString("Country"));
				L.setState(rs.getString("State"));
				L.setContact(rs.getString("Contact"));
				setCheck(1);
				dto.add(L);
			}
			
			if ( dto.isEmpty() ) {
				setCheck(0);
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return this.session;
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

	public int getCheck() {
		return this.check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	
}
