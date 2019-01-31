<%@ page 
	import="java.net.*, java.util.Date"
	contentType="text/html; charset=euc-jp"
%>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>
 
<% 
	//現在の時刻を取得
	Date now = new Date();

	//cookieに格納する文字列を作成
	String value = URLEncoder.encode(now.toString());
	
	//現在時刻のcookieを作成
	Cookie cookie = new Cookie("accessTime", value); //"accessTime"はgetName()で取得できる
	
	//cookieの寿命を設定( 日 * 時 * 分 * 秒 )
	cookie.setMaxAge(7 * 24 * 60 * 60); //有効期限は１週間
	cookie.setPath("/"); //有効なパスを指定（全部）
	
	//cookieを発
	response.addCookie(cookie);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel=stylesheet href="style.css" >
	<title>Cookie/cookie.jsp ページ</title>
</head>
<body>

<div id="bimg">
	<div id="bimg-mask">
		<table>
			<tr>
				<td>クッキーの設定</td>
			</tr>
			<tr>
				<td>このページにアクセスした時刻をcookieに設定しました。</td>
			</tr>
			<tr>
				<td></td>
			</tr>
		</table>
		<a href="http://localhost:8080/exam/Cookie/cookie2.jsp">クッキーの内容確認</a>
		
	</div>
</div>



</body>
</html>