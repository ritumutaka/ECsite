<%@ page contentType="text/html; charset=euc-jp"
%>

<%
	
	//クッキーを受け取ってみる
	Cookie cookies[] = request.getCookies();
	for (Cookie cookie : cookies ) {
		if ( "accessTime".equals(cookie.getName())) {
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
	}

	//クッキーを作成
	Cookie cookie = new Cookie("accessTime","");
	
	//クッキーの有効期間を０
	cookie.setMaxAge(0);
	
	//クッキーを発行
	response.addCookie(cookie);
	/* System.out.println(cookie.getName()); */
		
%>
    
    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>/Content/cookie3.jsp</title>
</head>
<body>
	<p>クッキーを破棄する</p>
	<p>クッキーの内容を削除しました</p>
	<p><a href="http://localhost:8080/exam/Cookie/cookie2.jsp">クッキーの内容を確認する</a></p>
</body>
</html>




