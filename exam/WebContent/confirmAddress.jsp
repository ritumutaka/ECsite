<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>confirmAddress.jsp</title>
</head>
<body>
	<div id="bimg">
		<div id="bimg-mask">
			<jsp:include page="header.jsp" />
			<h3>&lt;お届け先確認&gt;</h3>
			<br>
			<sss:form action="BUY">
				<table>
					<tbody>
						<tr><th>your name</th><td><sss:property value="#session.YourName"/></td>
						<tr><th>country</th><td><sss:property value="#session.YourCountry"/></td>
						<tr><th>State</th><td><sss:property value="#session.YourState"/></td></tr>
						<tr><th>your contact</th><td><sss:property value="#session.YourContact"/></td></tr>
					</tbody>
				</table>
				
				<h3>&lt;購入商品確認&gt;</h3>
				<br>
				<table>
					<tbody>
						<tr>
							<th>購入品 </th><td><sss:property  value="#session.buyItemName"/></td>
						</tr>
						<tr>
							<th>１つあたりの値段 </th><td><sss:property value="#session.$buyItemPrice"/></td>
						</tr>
						<tr>
							<th>購入個数</th><td><sss:property value="#session.buyCount"/></td>
						</tr>
						<tr>
							<th>合計金額</th><td><sss:property value="#session.total_price" /></td>
						</tr>
					</tbody>
				</table>
				<sss:submit value='BUY!!!'/>
			</sss:form>
		</div>
	</div>
			
</body>
</html>