<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="style.css">
	<title>userCreateConfirm.jsp ページ</title>
</head>
<body>
	<div id="bimg">
		<div id="bimg-mask">
			<h3>&lt;ユーザー登録&gt;</h3>
			<h4>登録する内容は以下でよろしいですか？</h4>
			<sss:form action="UserInsert">
				<table>
					<tr>
						<th>ID</th><th>pass</th><th colspan=3>生年月日</th>
					</tr>
					<tr>
						<td>
							<sss:property value="user_name"/>
						</td>
						<td>
							<sss:property value="password"/>
						</td>
						<td colspan=3>
							<sss:property value="birthDay"/>
						</td>
					</tr>
				</table>
				<sss:submit value="OK! register!"/>
			</sss:form>
		</div>
	</div>
	
</body>
</html>