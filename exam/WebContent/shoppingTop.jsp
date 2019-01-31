<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="style.css">
	<title>shoppingTop.jsp ページ</title>
</head>
<body>
	<div id="bimg">
		<div id="bimg-mask">
		<jsp:include page="header.jsp" />
			<h3>&lt;ジャンル選択&gt;</h3>
			
			<table>
				<tr>
					<sss:form action="Category">
					<!-- valueをitemsテーブルのCategoryと同じにしておくこと -->
						<th><sss:submit name="category" value="pc"/></th>
						<th><sss:submit name="category" value="desk"/></th>
						<th><sss:submit name="category" value="chair"/></th>
					</sss:form>
					
					</tr>
			</table>
		</div>
	</div>

</body>
</html>