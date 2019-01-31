<%--
	Author    : tool-taro.com
 --%>
 
 <%@page import="com.cookie.Action.CookieTest"
 		 import="java.util.ArrayList"
 %>
 <%@page contentType="text/html" pageEncoding="UTF-8" session="false" %>
 
 <% 
 
 	//Cookieから"test_cookie_name"というKeyで登録された値(文字列)を取り出す
 	String value = CookieTest.getCookie(request, "test_cookie_name");
 
 	//valueがnullの場合のみCookieをセットする（期限は５分）
 	if ( value == null ) {
 		CookieTest.setCookie(request, response, "/", "test_cookie_name", "test_cookie_value", 5 * 60);
 	}
 	
 	if ( value != null ) {
 		CookieTest.setCookie(request, response, "/", "test_cookie_name", "", 0);
 	}
 	
 %>
 
 <!DOCTYPE html>
 <html>
 	<head>
 		<title>tooi-taro.com</title>
 	</head>
 	<body>
 		取得した値＝"<%= value %>"
 		<% if ( value == null ) {
 			System.out.println("aaa");
 		}
 		%>
 	</body>
 </html>