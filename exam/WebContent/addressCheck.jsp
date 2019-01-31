<%@ page import="com.action.LoginAction"
		import="java.util.ArrayList"
		import="com.dao.LoginActionDAO"
		import="com.dto.LoginActionDTO"
		import="java.util.Map"
		import="org.apache.struts2.interceptor.SessionAware"
		import="com.cookie.Action.CookieTest"
		import="com.dao.CartDAO"
		import="com.action.AddressCheck"
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel=stylesheet href="style.css" >
	<title>addressCheck.jsp</title>
</head>
<body>
<div id="bimg">
 <div id="bimg-mask">
 <jsp:include page="header.jsp" />

	<h2>&lt;ユーザー情報&gt;</h2>
	<table>
		<tr>
			<th>id_number</th>
			<th>user_name</th>
			<th>password</th>
			<th>生年月日</th>
		</tr>
		<tr>
			<td><sss:property value="#session.userId_number"/></td>
			<td><sss:property value="#session.user_name"/></td>
			<td><sss:property value="#session.password"/></td>
			<td><sss:property value="#session.birthDay"/></td>
		</tr>
	</table>
	
	
	<h2>&lt;宛先情報&gt;</h2>
	<%
		AddressCheck a = new AddressCheck();
		ArrayList<LoginActionDTO> A = new ArrayList<LoginActionDTO>();
		A = a.getAddress((int)session.getAttribute("userId_number"));
		if(	a.getCheck() > 0 ) { 
			for ( int i = 0; A.size() > i; i++) {
	%>
	<%-- <sss:iterator value="L"> --%>
		<p><%=i+1 %></p>
		<table>
			<tr>
				<th>国</th>
				 <td><%=A.get(i).getCountry() %></td>
				<%-- <td><sss:property value="Country" /></td> --%>
				
			</tr>
			<tr>
				<th>州</th>
				<td><%=A.get(i).getState() %></td>
			</tr>
			<tr>
				<th>電話番号</th>
				<td><%=A.get(i).getContact() %></td>
			</tr>
		</table>
	<%-- </sss:iterator> --%>
	
	<%
			}
		} else { 
	%>

	<table>
		<tr>
			<th>国</th>
			<td rowspan=3>宛先情報が未設定です</td>
		</tr>
		<tr>
			<th>州</th>
		</tr>
		<tr>
			<th>電話番号</th>
		</tr>
	</table>
	
	<% } %>
	
	<h2>&lt;追加する宛先&gt;</h2>

	<sss:form action="AddressReset">
		<table>
			<tbody>
				<tr><th>国</th>
				<td>
					<select name="Country">
						<option value="Japan" selected="selected">Japan</option>
						<option value="USA">USA</option>
						<option value="China">China</option>
						<option value="Philippines">Philippines</option>
						<option value="Canada">Canada</option>
					</select>
				</td>
				<tr><th>州</th><td><sss:textfield name="State"/></td></tr>
				<tr><th>電話番号</th><td><sss:textfield name="Contact" type="tel"/></td></tr>
			</tbody>
		</table>
		<sss:submit value="この宛先を追加する"/>
	</sss:form>

 </div>
</div>
	
</body>
</html>