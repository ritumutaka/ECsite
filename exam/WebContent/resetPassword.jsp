<%@ page import="com.action.LoginAction" import="java.util.ArrayList"
	import="com.dao.LoginActionDAO" import="com.dto.LoginActionDTO"
	import="java.util.Map"
	import="org.apache.struts2.interceptor.SessionAware"
	import="com.cookie.Action.CookieTest" import="com.dao.CartDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="style.css">
<title>resetPassword.jsp ページ</title>
</head>
<body>

	<div id="bimg">
		<div id="bimg-mask">
			<jsp:include page="header.jsp" />

			<h2>&lt;パスワード再設定&gt;</h2>

			<table border="1">
				<tr>
					<th>user_name</th>
				</tr>
				<tr>
					<td><sss:property value="#session.user_name" /></td>
				</tr>
			</table>

			<h2>&lt;本人確認&gt;</h2>
			<form action="ResetPassword">
				<table>
					<tr>
						<th>生年月日</th>
						<td><select name="year">
								<%for (int year = 2018; year > 1900; year--) { %>
								<option value=<%=year %>><%=year %> 年
								</option>
								<%} %>
						</select></td>
						<td><select name="month">
								<%for (int month = 1; month <= 12; month++) { %>
								<option value=<%=month %>><%=month %>月
								</option>
								<%} %>
						</select></td>
						<td><select name="day">
								<%for (int day = 1; day <= 31; day++) { %>
								<option value=<%=day %>><%=day %>日
								</option>
								<%} %>
						</select></td>
					</tr>
					<tr>
						<th>旧パスワード</th>
						<td colspan=3><sss:textfield type="password"
								name="oldPassword" /></td>
					</tr>
					<tr>
						<th>新パスワード</th>
						<td colspan=3><sss:textfield type="password"
								name="newPassword" /></td>
					</tr>
				</table>
				<button type="submit">再設定する</button>
			</form>
		</div>
	</div>

</body>
</html>