<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>


<%-- <%
	//Cookieを使用する
	
	//全てのクッキーを配列としてを取得
	Cookie cookies[] = request.getCookies();

	//目的のクッキーを格納する変数を準備
	String Auser_name = null;
	String Apassword = null;
	
	//それぞれのクッキーに対して名前を確認
	//配列なので目的のcookieを取得するためには確認が必要
	if( cookies != null ) {
		for(int i = 0; i < cookies.length; i++) {
			
			//名前が"accessTime"であるか確認
			//getName()でクッキー名前を取得可能
			if(cookies[i].getName().equals("user_name")) {
				Auser_name = cookies[i].getValue();
			} else if(cookies[i].getName().equals("password")) {
				Apassword = cookies[i].getValue();	
			}
		}
	}
	
%> --%>



<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>home.jsp ページ</title>
</head>

<body>
	<div id="bimg">
		<div id="bimg-mask">
			<h3>&lt;login!&gt;</h3>
			<br>
			<sss:form action="LoginAction">
				<table>
					<tbody>
						<tr>
							<td>ID </td><td><sss:textfield  name="user_name" /></td>
						</tr>
						<tr>
							<td>PASS </td><td><sss:password name="password"/></td>
						</tr>
					</tbody>
				</table>
				<a href='<sss:url action="ToUserCreatePage"/>'>ユーザー登録</a>
				<sss:submit id="a" value="login!"/>
			</sss:form>
			
			<!-- 画像挿入 -->
			<!-- <img src="/photos/104277.jpg"> -->
			
			<%-- <sss:form action="cookie">
				<sss:submit value="クッキー"></sss:submit>
			</sss:form> --%>
			
		</div>
	</div>
</body>
</html>
