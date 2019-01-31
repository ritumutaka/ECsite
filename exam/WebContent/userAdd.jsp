<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>userAdd.jsp</title>
</head>
<body>
<div id="bimg">
		<div id="bimg-mask">

			<h3>&lt;ユーザー登録&gt;</h3>
			
			<sss:form action="UserAdd">
				<table>
					<tr>
						<td>ユーザー名</td><td><sss:textfield name="AddUserName"></sss:textfield></td>
					</tr>
					<tr>
						<td>パスワード</td><td><sss:textfield name="AddUserPassword"></sss:textfield></td>
					</tr>
				</table>
				<sss:submit value="登録"/>
			</sss:form>
			
			<a href="admin.jsp">管理TOPへ</a>
		</div>
		</div>
	
</body>
</html>