package com.action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.dao.LoginActionDAO;
import com.dto.LoginActionDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport  implements SessionAware {

	private String createFinish = "";
	private String result;
	private String user_name;
	private String password;
	//ActionSupport用　新しく定数定義
	private String ROOT = "root";
	private ArrayList<LoginActionDTO> LoginActionDTOList = new ArrayList<LoginActionDTO>();
	public Map<String, Object> session;
	private LoginActionDTO loginL;
	public ArrayList<LoginActionDTO> userBuyItemInfoList = new ArrayList<LoginActionDTO>();
	LoginActionDAO Ldao = new LoginActionDAO();
	
	public String login() {
		loginL = Ldao.getUserInfo(user_name, password);
		if( loginL.getId_number() > 0 ) {
			session.put("userId_number", loginL.getId_number());
			session.put("user_name", loginL.getUser_name());
			session.put("password", loginL.getPassword());
			session.put("birthDay", loginL.getBirthDay());
			session.put("loginFLG", true);
			result = SUCCESS;
		} else {
			System.out.println("ユーザー名かパスワードが違います");
			System.out.println("ユーザー名：" + user_name);
			System.out.println("パスワード：" + password);
			System.out.println("------------------------------------------");
			result = ERROR;
		}
		//後々getさせるためにsetしておく
		setLoginActionDTO(loginL);
		
		//list はまだ使ってないはずset,getではなくlistでも良いかも
		/*LoginActionDTOList.add(loginL);*/
		
		//result == SUCCESS はnull回避
		if(result == SUCCESS){
			//テーブルから購入履歴を取得
			//userBuyItemList には買ったモノ、個数、小計が入っている
			userBuyItemInfoList = Ldao.getBuyItems((int)session.get("userId_number"));
			//管理者かどうか判断
			if ( loginL.getAdmin_flg().contentEquals("root") ) {
				result = ROOT;
			}
		}
		return result;
	}
	

//jsp用
//<s:property value="userBuyItemInfoList"/>で参照可能
		public ArrayList<LoginActionDTO> getUserBuyItemInfoList() {
			return this.userBuyItemInfoList;
		}
		
		public void setUserBuyItemInfoList(ArrayList<LoginActionDTO> userBuyItemInfoList) {
			this.userBuyItemInfoList = userBuyItemInfoList;
		}
	
	public void setCreateFinish(String createFinish) {
		this.createFinish = createFinish;
	}
	public String getCreateFinish() {
		return this.createFinish;
	}
		
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_name() {
		return this.user_name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return this.password;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	
	public ArrayList<LoginActionDTO> getLoginActionDTOList() {
		return this.LoginActionDTOList;
	}
	
	
	//HomeActionで取得するためにsetしておいて、getさせる
	public void setLoginActionDTO(LoginActionDTO loginL) {
		this.loginL = loginL;
	}
	public LoginActionDTO getLoginActionDTO() {
		return this.loginL;
	}
	
}
