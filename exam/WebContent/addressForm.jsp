<%@ page 
	import="com.action.AddressCheck"
	import="java.util.ArrayList"
	import="com.dto.LoginActionDTO"
 %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>addressForm.jsp</title>
</head>
<body>
<div id="bimg">
 <div id="bimg-mask">
 <jsp:include page="header.jsp" />
 
 <% 
 	AddressCheck A = new AddressCheck();
 	ArrayList<LoginActionDTO> L = new ArrayList<LoginActionDTO>();
 	L = A.getAddress((int)session.getAttribute("userId_number"));
 	
 %>
 
 <!-- 設定してあるアドレスから選択 -->
 <h2>&lt;設定済みのお届け先&gt;</h2>
 	<form action="ToConfirmAddress">
<%
	if(L.size() > 0) {
 		for(int i = 0; L.size() > i; i++) {
%>
	 	<table style="width: 60%; display:inline-block;">
			 <tr>
				<th>登録番号</th>
				<td> <%=i+1 %></td>
			 </tr>
			<tr>
				<th>国</th>	
				<td><%=L.get(i).getCountry() %></td>
			</tr>
			 <tr>
				<th>州</th>
			 	<td><%=L.get(i).getState() %></td>
			 </tr>
			 <tr>
				<th>電話番号</th>
			 	<td><%=L.get(i).getContact() %></td>
			 </tr>
		</table>
		<button id="Button" style="width: 20%;" type="submit" value="<%=i+1%>" name="addressSelectNumber"><%=i+1 %>番の宛先に送る</button>

<%
 		}
%>
	</form>
<%
 	} else {
%>
	<table style="width: 90%;">
		<tr>
			<td>未設定です</td>
		</tr>
	</table>
<%
 	}
%>

 <!-- アドレス直入力フォーム -->
	<h2>&lt;アドレス直入力&gt;</h2>
	<br>
	<sss:form action="ToConfirmAddress">
		<table>
			<tbody>
				<tr><th>your name</th><td><sss:textfield name="YourName"/></td>
				<tr><th>Country</th>
				<td>
					<select name="YourCountry">
						<option value="Japan" selected="selected">Japan</option>
						<option value="USA">USA</option>
						<option value="China">China</option>
						<option value="Philippines">Philippines</option>
						<option value="Canada">Canada</option>
					</select>
				</td>
				<tr><th>State</th><td><sss:textfield name="YourState"/></td></tr>
				<tr><th>your contact</th><td><sss:textfield name="YourContact" type="tel"/></td></tr>
			</tbody>
		</table>
		<button type="submit" name="addressSelectNumber" value="0">ここへ送る</button>
	</sss:form>
	
	
	
 </div>
</div>
</body>
</html>