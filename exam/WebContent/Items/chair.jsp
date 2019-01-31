<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="../style.css">
	<title>chair.jsp ページ</title>
</head>
<body>
	<div id="bimg">
				<div id="bimg-mask">
			<h3>&lt;イス買いますか？&gt;</h3>
			
			<table>
				<sss:form action="ToBuyPage">
					<tr>
						<td>いいやつ</td>
						<td><sss:property value="aaa" />５万円</td>
						<td><sss:submit name="buyItemName" value="良い椅子"/></td>
					</tr>
				</sss:form>
				<sss:form action="ToBuyPage">
					<tr>
						<td>わるいやつ</td><td><sss:property value="aaa"/>５０円</td><td><sss:submit name="buyItemName" value="悪い椅子"/></td>
					</tr>
				</sss:form>
			</table>
		</div>
	</div>


</body>
</html>