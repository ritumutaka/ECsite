package com.cookie.Action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionSupport;


/*@author tool-taro.com*/
public class CookieTest extends ActionSupport {

	static Cookie[] cookies;
	
	public String execute() {
		return SUCCESS;
	}
	
	
	public static String getCookie(HttpServletRequest request, String name) {
		String result = null;
		
		cookies = request.getCookies();
		if ( cookies != null ) {
			for ( Cookie cookie : cookies ) {
				if ( name.equals(cookie.getName())) {
					result = cookie.getValue();
					break;
				}
			}
		}
		System.out.println(cookies[2].getName());
		return result;
	}
	
	
	public static void setCookie(HttpServletRequest request, HttpServletResponse response, String path, String name, String value, int maxAge) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(maxAge);
		cookie.setPath(path);
		
		response.addCookie(cookie);
	}
	
}
