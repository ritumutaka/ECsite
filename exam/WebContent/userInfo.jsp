<%@ page import="com.action.LoginAction"
		import="java.util.ArrayList"
		import="com.dao.LoginActionDAO"
		import="com.dto.LoginActionDTO"
		import="java.util.Map"
		import="org.apache.struts2.interceptor.SessionAware"
		import="com.cookie.Action.CookieTest"
		import="com.dao.CartDAO"
		import="com.dao.SortDAO"
		
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags" %>


<%-- <%
	/*cookieにusernameとpasswordをセット*/
	LoginActionDTO dto = new LoginActionDTO();
	System.out.println(dto.getUser_name());
	
	/* クッキー配列を作成 */
	/* Cookie cookies[] = new Cookie[1]; */
	
	Cookie cookie = new Cookie("user_name", dto.getUser_name());
	cookie.setMaxAge(60 * 60 * 24 * 7);
	cookie.setPath("/");
	/* cookies[0] = cookie; */

	Cookie cookie2 = new Cookie("password", dto.getPassword());
	cookie2.setMaxAge(60 * 60 * 24 * 7);
	cookie2.setPath("/");
	/* cookies[1] = cookie2; */
	
	response.addCookie(cookie);
%> --%>

<%
 	SortDAO SORT = new SortDAO();
 	ArrayList<LoginActionDTO> userBuyItemInfoList = new ArrayList<LoginActionDTO>();
	userBuyItemInfoList = SORT.SortByDateASC((int)session.getAttribute("userId_number"));
	session.setAttribute("userBuyItemInfoList", userBuyItemInfoList);
%>


<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel=stylesheet href="style.css" >
	<title>userInfo.jsp ページ</title>
</head>
<body>


	<div id="bimg">
		<div id="bimg-mask">
		<!-- ヘッダーをインクルード -->
		<jsp:include page="header.jsp" />
			<h2>&lt;マイページ&gt;</h2>
			
			<%-- 	<sss:iterator value="LoginActionDTOList"> --%>
				<table border="1">
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
				
<!-- パスワード再設定画面へ -->
			<a href="resetPassword.jsp">パスワードを再設定する</a>
			
<!-- 宛先設定・確認画面へ -->
			<a href='<sss:url action="AddressCheck" />'>宛先を設定・確認する</a>
			
			<%-- 	</sss:iterator> --%>
			
			<h2>&lt;購入履歴&gt;</h2>
			
			
<!-- ソート機能 -->
			<sss:form action="Sort">
				<select class="submit_btn" name="sort">
					<option value="a" style="background-color: #397a70; color: #ffffff">並び替え方を選択</option>
					<option value="a">日付が古い順</option>	
					<option value="b">日付が新しい順</option>
					<option value="c">価格が安い順</option>
					<option value="d">価格が高い順</option>
				</select>
				<sss:submit class="submit_btn" value="並び替える" />
			</sss:form>
		
			
<!-- 購入履歴を表示 -->
		<sss:if test="userBuyItemInfoList.size() > 0">
			<sss:iterator value="userBuyItemInfoList">
					<table style="width: 90%;">
						<tr>
							<th>モノ</th>
							<th>価格</th>
							<th>個数</th>
							<th>金額</th>
							<th>購入日時</th>
						</tr>
						<tr>
							<td><sss:property value="buyItemName"/></td>
							<td><sss:property value="buyItemPrice"/></td>
							<td><sss:property value="buyCount"/></td>
							<td><sss:property value="total_price"/></td>
							<td><sss:property value="buyDate"/></td>
						</tr>	
					</table>
				</sss:iterator>
			</sss:if>
			<sss:elseif test="#session.userBuyItemInfoList.size() > 0">
				<% for (int i = 0; userBuyItemInfoList.size() > i; i++) {%>
				<table style="width: 90%;">
						<tr>
							<th>モノ</th>
							<th>価格</th>
							<th>個数</th>
							<th>金額</th>
							<th>購入日時</th>
						</tr>
						<tr>
							<td><%=userBuyItemInfoList.get(i).getBuyItemName() %></td>
							<td><%=userBuyItemInfoList.get(i).getBuyItemPrice() %></td>
							<td><%=userBuyItemInfoList.get(i).getBuyCount() %></td>
							<td><%=userBuyItemInfoList.get(i).getTotal_price() %></td>
							<td><%=userBuyItemInfoList.get(i).getBuyDate() %></td>
						</tr>	
					</table>
				<% } %>
			</sss:elseif>
	<!-- 購入履歴がなければ表示 -->
			<sss:else>
				<table>
					<tr>
						<td>購入した商品はありません。</td>
					</tr>
				</table>
			</sss:else>
			
			
<!-- カートを表示 -->
		<h2>&lt;カート&gt;</h2>
		
		<% 
			CartDAO Cdao = new CartDAO();
			ArrayList<LoginActionDTO> userCartItemInfoList = new ArrayList<LoginActionDTO>();
			userCartItemInfoList = Cdao.getCart((int)session.getAttribute("userId_number"));
			
			//iteratorが表示できないのでfor
			for ( int i = 0; userCartItemInfoList.size() > i; i++) {
		%>
				<table style="width: 90%;">
					<tr>
						<th>モノ</th>
						<th>価格</th>
						<th>個数</th>
						<th>金額</th>
						<th>追加日時</th>
						<th>カートから削除</th>
					</tr>
					<tr>
						<td><%=userCartItemInfoList.get(i).getBuyItemName() %></td>
						<td><%=userCartItemInfoList.get(i).getBuyItemPrice() %></td>
						<td><%=userCartItemInfoList.get(i).getBuyCount() %></td>
						<td><%=userCartItemInfoList.get(i).getTotal_price() %></td>
						<td><%=userCartItemInfoList.get(i).getBuyDate() %></td>
						<td>
							<sss:form action="DeleteCart">
								<button type="submit" name="cartItemNumber" value=<%=userCartItemInfoList.get(i).getId_number() %>>この商品を削除</button>
							</sss:form>
						</td>
					</tr>
				</table>
			
			<%
				}
				if( userCartItemInfoList.size() == 0 ) {
			%>
			<table>
				<tr>
					<td>カートに入れた商品はありません。</td>
				</tr>
			</table>
			<%
				}
			%>
			
			
<!-- 購入履歴全削除 -->
			<sss:form class="Button" action="Delete">
				<sss:submit class="submit_btn" value="購入履歴を全て消去する"/>
			</sss:form>
			
<!-- カート中身全削除 -->
			<form class="Button" action="DeleteCart">
				<button class="submit_btn" type="submit" name="cartItemNumber" value="0">カートの中身を全て破棄する</button>
			</form>

<!-- カートの中身全購入 -->
			<form class="Button" action="BUY">
				<button class="submit_btn" type="submit" name="buyItemName" value="buyAll">カートの中身を全購入</button>
			</form>
			
		</div>
	</div>
	
</body>
</html>