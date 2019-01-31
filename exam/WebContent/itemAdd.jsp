<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>itemAdd.jsp</title>
</head>
<body>
	<div id="bimg">
		<div id="bimg-mask">

			<h3>&lt;商品登録&gt;</h3>
			
			<sss:form action="ItemAdd">
				<table>
					<tr>
						<td>商品の名前</td><td><sss:textfield name="AddItemName"></sss:textfield></td>
					</tr>
					<tr>
						<td>商品の価格</td><td><sss:textfield type="number" name="AddItemPrice"></sss:textfield></td>
					</tr>
					<tr>
						<td>商品のカテゴリー</td>
						<td>
							<select name="AddItemCategory">
							　	<option value=1>pc</option>
								<option value=2>机</option>
								<option value=3>椅子</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>商品説明</td>
						<td><sss:textfield name="AddItemDiscription"></sss:textfield></td>
					</tr>
				</table>
				<sss:submit value="登録"/>
			</sss:form>
			
			<a href="admin.jsp">管理TOPへ</a>
		</div>
	</div>
</body>
</html>