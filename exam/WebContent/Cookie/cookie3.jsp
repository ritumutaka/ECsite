<%@ page contentType="text/html; charset=euc-jp"
%>

<%
	
	//���å����������äƤߤ�
	Cookie cookies[] = request.getCookies();
	for (Cookie cookie : cookies ) {
		if ( "accessTime".equals(cookie.getName())) {
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
	}

	//���å��������
	Cookie cookie = new Cookie("accessTime","");
	
	//���å�����ͭ�����֤�
	cookie.setMaxAge(0);
	
	//���å�����ȯ��
	response.addCookie(cookie);
	/* System.out.println(cookie.getName()); */
		
%>
    
    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>/Content/cookie3.jsp</title>
</head>
<body>
	<p>���å������˴�����</p>
	<p>���å��������Ƥ������ޤ���</p>
	<p><a href="http://localhost:8080/exam/Cookie/cookie2.jsp">���å��������Ƥ��ǧ����</a></p>
</body>
</html>




