<%@ page
	import="com.dao.CategoryDAO"
	import="java.util.ArrayList"
	import="com.dto.LoginActionDTO"
	import="com.action.Cart"
 %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	
	<meta name="keywords" content=""/>
	
	<link rel="stylesheet" href="style.css">
	<title>category.jsp ページ</title>
	
	<!-- 使ってない謎関数 呼び出しは onClick="kotae()" こんな感じ-->
<!-- <script>
	function kotae(){
	var buyItem = buyItem;
	alert(buyItem);
	return buyItem;
	}
</script> -->
	
</head>
<body>


<%
	LoginActionDTO DTO = new LoginActionDTO();
	CategoryDAO L = new CategoryDAO();
	ArrayList<LoginActionDTO> List = new ArrayList<LoginActionDTO>();
	List = L.getCategory((int)session.getAttribute("category"));
	
%>
	<div id="bimg">
		<div id="bimg-mask">
		<jsp:include page="../header.jsp" />
				<!-- 表示側 -->
			<h3>&lt;<sss:property value="categoryName"/>買いますか？&gt;</h3>
			
			<table>
				<tr>
					<th>商品名</th>
					<th>値段</th>
					<th>買いますか？</th>
					<th>カートに保存</th>
				</tr>
			<%
				for(int i = 0; List.size() > i ; i++ ){
			%>
				<tr>
					<sss:form action="ToBuyPage">
						<td><%=List.get(i).getBuyItemName() %></td>
						<td>￥<%=List.get(i).getBuyItemPrice() %></td>
						<td><button type="submit" name="buyItemName" value="<%=List.get(i).getBuyItemName() %>">購入する</button></td>
					</sss:form>
					<sss:form action="Cart">
						<td>
							<select name="Count">
								<option value="1" selected="selected">1コ</option>
								<option value="2">2コ</option>
								<option value="3">3コ</option>
								<option value="4">4コ</option>
								<option value="5">5コ</option>
							</select>
							<button type="submit" name="cartItemIdNumber" value="<%=List.get(i).getId_number() %>">カートへ</button>
						</td>
					</sss:form>
					</tr>
				
				
			<%
				}
			%>
			
			</table>
			
			<!-- <script language=JavaScript>
				function func(MyCommand) {
					document.MyForm.MySubmit.value=MyCommand;
					document.MyForm.submit();
					document.wright(MyCommand);
				}
			</script> -->
		
		</div>
	</div>


</body>
</html>
				