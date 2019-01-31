<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>
<!DOCTYPE>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel=stylesheet href="style.css">
	<title>userCreate.jsp ページ</title>
</head>
<body>
	<div id="bimg">
		<div id="bimg-mask">
		
			<h3>&lt;ユーザー登録&gt;</h3>
		
			<sss:form action="UserCreateCheckDuplication">
				<table>
					<tbody>
						<tr>
							<td>ID </td><td colspan=3><sss:textfield name="user_name"/></td>
						</tr>
						<tr>
							<td>PASS </td><td colspan=3><sss:password name="password"/></td>
						</tr>
						<tr>
							<td>生年月日 </td>
							<td>
								<select name="year">
								<%for (int year = 2018; year > 1900; year--) { %>
									<option value=<%=year %>><%=year %> 年</option>
								<%} %>
								</select>
							</td>
							<td>
								<select name="month">
								<%for (int month = 1; month <= 12; month++) { %>
									<option value=<%=month %>><%=month %>月</option>
								<%} %>
								</select>
							</td>
							<td>
								<select name="day">
								<%for (int day = 1; day <= 31; day++) { %>
									<option value=<%=day %>><%=day %>日</option>
								<%} %>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
				<sss:submit id="a" value="register!"/>
			</sss:form>
		
			<a href="home.jsp">ログイン画面へ</a>
		</div>
	</div>
</body>
</html>