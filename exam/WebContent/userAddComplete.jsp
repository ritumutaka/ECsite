<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>userAddComplete.jsp</title>
</head>
<body>
<div id="bimg">
			<div id="bimg-mask">
			<h3>&lt;ユーザー登録完了&gt;</h3>
			
		
			<table>
				<tr>
					<td>ユーザー名</td><td><sss:property value="AddUserName"></sss:property></td>
				</tr>
				<tr>
					<td>パスワード</td><td><sss:property value="AddUserPassword"></sss:property></td>
				</tr>
			</table>
			
			<a href="admin.jsp">管理TOPへ</a>
		</div>
	</div>
	
</body>
</html>