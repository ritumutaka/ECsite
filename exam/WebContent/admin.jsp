<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>admin.jsp</title>
</head>
<body>
	<div id="bimg">
		<div id="bimg-mask">

			<h3>&lt;管理TOP&gt;</h3>
			<br>
			
			<table>
				<tbody>
					<tr>
						<td>商品管理</td><td>ユーザー管理</td>
					</tr>
					<tr>
						<td> 
							<sss:form class="Button" action="ToItemAdd">
								<sss:submit class="Button" value="商品登録"/>
							</sss:form>
						</td>
						<td>
							<sss:form class="Button" action="ToUserAdd">
								<sss:submit class="Button" value="ユーザー登録"/>
							</sss:form>
						</td>
					</tr>	
					<tr>
						<td>
							<sss:form class="Button" action="ToAllItemPage">
								<sss:submit class="Button" value="商品一覧"/>
							</sss:form>
						</td>
						<td>
							<sss:form class="Button" action="ToAllUserPage">
								<sss:submit class="Button" value="ユーザー一覧"/>
							</sss:form>
						</td>
					</tr>
				</tbody>
			</table>
			
			<a href="home.jsp">ログイン画面へ</a>
		</div>
	</div>
</body>
</html>