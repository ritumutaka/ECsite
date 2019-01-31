<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	
	<meta name="keywords" content=""/>
	
	<link rel="stylesheet" href="../style.css">
	<title>pc.jsp ページ</title>
	
	<!-- 使ってない謎関数 呼び出しは onClick="kotae()" こんな感じ-->
<script>
	function kotae(){
	var buyItem = buyItem;
	alert(buyItem);
	return buyItem;
	}
</script>
	
</head>
<body>
	<div id="bimg">
			<div id="bimg-mask">
	
			<h3>&lt;PC買いますか？&gt;</h3>
			
			<table>
				<sss:form action="ToBuyPage">
					<tr>
						<td>いいやつ</td>
						<td><sss:property value="aaa" />３０万円</td>
						<td><sss:submit name="buyItemName" value="良いPC"/></td>
					</tr>
				</sss:form>
				<sss:form action="ToBuyPage">
					<tr>
						<td>わるいやつ</td><td><sss:property value="aaa"/>３０円</td><td><sss:submit name="buyItemName" value="悪いPC"/></td>
					</tr>
				</sss:form>
			</table>
			
		</div>
	</div>


</body>
</html>