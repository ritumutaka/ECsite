<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>buyPage.jsp ページ</title>
</head>
<body>
	<div id="bimg">
		<div id="bimg-mask">
			<jsp:include page="header.jsp" />
				<h3>&lt;商品詳細&gt;</h3>
				<br>
				<sss:form action="Cart">
					<table>
						<tbody>
							<tr>
								<th>商品名 </th><td><sss:property  value="#session.buyItemName"/></td>
							</tr>
							<tr>
								<th>１つあたりの値段 </th><td>\<sss:property value="#session.buyItemPrice"/></td>
							</tr>
							<tr>
								<th>いくつ買いますか？ </th>
								<td>
									<select name="Count">
										<option value="1" selected="selected">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
									</select>
								</td>
							</tr>
							<tr>
								<th>商品説明</th><td><sss:property value="#session.discription"/></td>
							</tr>
						</tbody>
					</table>
				<sss:submit value="カートへ入れる"/>
			</sss:form>
		</div>
	</div>
</body>
</html>