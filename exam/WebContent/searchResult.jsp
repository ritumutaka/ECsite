
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>

<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel=stylesheet href="style.css" >
	<title>searchResult.jsp ページ</title>
</head>
<body>

<div id="bimg">
	<div id="bimg-mask">
	<jsp:include page="header.jsp" />
		<sss:if test="L.size() > 0 ">
			<sss:iterator value="L">
				<div class="product-wrapper">
					<a href='<sss:url action="ToBuyPage"><sss:param name="id_number" value="%{id_number}" /></sss:url>'>
						<img class="photo" src='<sss:property value="imagePath"/>'>
					</a>
						<ul>
							<li class="photoDescription"><sss:property value="buyItemName"/></li>
							<li class="photoDescription">\<sss:property value="buyItemPrice"/></li>
						</ul>
				</div>
				
			</sss:iterator>
		</sss:if> 
		<sss:else>
			<br>
			<h1>検索結果がありませんでした。</h1>
		</sss:else>
	</div>
</div>

</body>
</html>