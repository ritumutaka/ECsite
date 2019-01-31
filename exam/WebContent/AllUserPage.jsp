<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>
<%@ page import="com.dao.ToAllUserPageDAO"
		import="java.util.ArrayList"
		import="java.util.Map"
		import="com.dto.LoginActionDTO"
%>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>AllUserPage.jsp</title>
</head>
<body>
<div id="bimg">
			<div id="bimg-mask">

			<h3>&lt;ユーザー一覧&gt;</h3>
			
		<%
			ToAllUserPageDAO AllUserDAO = new ToAllUserPageDAO();
			ArrayList<LoginActionDTO> AllUserList = new ArrayList<LoginActionDTO>(); 
			AllUserList = AllUserDAO.getAllUser();
		%>
				
				<table>
					<tr>
						<th>ユーザーNo</th><th>ユーザー名</th><th>パスワード</th>
					</tr>
				<% for ( int i = 0 ; i < AllUserList.size() ; i++) { %>
					<tr>
						<td><%=AllUserList.get(i).getId_number() %></td>
						<td><%=AllUserList.get(i).getUser_name() %></td>
						<td><%=AllUserList.get(i).getPassword() %></td>
					</tr>
				<% } %>
				</table>
			
			<a href="admin.jsp">管理TOPへ</a>
			
		</div>
	</div>
	
</body>
</html>