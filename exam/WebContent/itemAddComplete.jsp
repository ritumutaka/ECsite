<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>itemAddComplete.jsp</title>
</head>
<body>
<div id="bimg">
		<div id="bimg-mask">
			<h3>&lt;商品登録完了&gt;</h3>
			
		
			<table>
				<tr>
					<td>商品の名前</td><td><sss:property value="AddItemName"></sss:property></td>
				</tr>
				<tr>
					<td>商品の価格</td><td><sss:property value="AddItemPrice"></sss:property></td>
				</tr>
				<tr>
					<td>商品のカテゴリー</td><td><sss:property value="AddItemCategory"></sss:property></td>
				</tr>
			</table>
			
			<a href="admin.jsp">管理TOPへ</a>
		</div>
	</div>
			
</body>
</html>