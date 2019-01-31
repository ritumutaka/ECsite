<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="style.css" >
<title>header.jsp</title>
</head>
<body>

<script>
	function goLoginAction() {
		document.getElementById("b").action="LoginAction";
	}
	function goLogoutAction() {
		document.getElementById("b").action="Logout";
	}
	function goMyPage() {
		document.getElementById("b").action="HomeAction";
	}
	function goSerch() {
		document.getElementById("b").action="Search";
	}
</script>
		<div id="header">
			<div id="header-bimg">
				<h3 id="header-title">&lt;exam&gt;</h3>
				<ul id="header-list">
					<sss:form action="Search" id="searchForm">
						<li>	
							<select class="submit_btn" id=select name="categoryId">
								<option value="0">すべて</option>
								<option value="1">PC</option>
								<option value="2">机</option>
								<option value="3">椅子</option>
							</select>
						</li>
						<li><sss:textfield name="keywords" placeholder="検索"></sss:textfield></li>
						<li><sss:submit class="submit_btn" type="submit" onclick="goSerch();" value="商品検索"/></li>
					</sss:form>
					<sss:form id="b" name="form">
						<sss:if test='#session.containsKey("loginFLG")'>
							<li><button class="submit_btn" type="submit" onclick="goLogoutAction();" >ログアウト</button></li>
						</sss:if> <sss:else>
							<li><button class="submit_btn" type="submit" onclick="goLoginAction();" >ログイン</button></li>
						</sss:else>
						<li><button class="submit_btn" type="submit" onclick="goMyPage();" >マイページへ</button></li>
					</sss:form>
				</ul>
			</div>
		</div>

</body>
</html>