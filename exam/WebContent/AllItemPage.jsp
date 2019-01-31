<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>
<%@ page import="com.dao.ToAllItemPageDAO"
		import="java.util.ArrayList"
		import="java.util.Map"
		import="com.dto.LoginActionDTO"
%>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>AllItemPage.jsp</title>
</head>
<body>
<div id="bimg">
	<div id="bimg-mask">

			<h3>&lt;商品一覧&gt;</h3>
			
		<%
			ToAllItemPageDAO AllItemDAO = new ToAllItemPageDAO();
			ArrayList<LoginActionDTO> AllItemList = new ArrayList<LoginActionDTO>(); 
			AllItemList = AllItemDAO.getAllItem();
		%>
				
				<table>
					<tr>
						<th>商品ID</th><th>商品の名前</th><th>価格</th><th>カテゴリー</th>
					</tr>
				<% for ( int i = 0 ; i < AllItemList.size() ; i++) { %>
					<tr>
						<td><%=AllItemList.get(i).getId_number() %></td>
						<td><%=AllItemList.get(i).getBuyItemName() %></td>
						<td><%=AllItemList.get(i).getBuyItemPrice() %></td>
						<td><%=AllItemList.get(i).getItemCategory() %></td>
					</tr>
				<% } %>
				</table>
				
			<a href="admin.jsp">管理TOPへ</a>
		</div>
	</div>
	
</body>
</html>