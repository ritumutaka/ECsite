package com.action;

import com.dao.ToAllItemPageDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ToAllItemPage extends ActionSupport {

	public ToAllItemPageDAO a = new ToAllItemPageDAO();
	public String execute() {
		//移動だけAction
		return SUCCESS;
	}
}
