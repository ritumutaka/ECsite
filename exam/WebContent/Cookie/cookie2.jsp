<%@ page 
	import="java.net.*"
	contentType="text/html; charset=euc-jp"
%>

<%
	//Cookie����Ѥ���
	
	//��Ū�Υ��å�����������
	//getCookies()������Ȥ��������å�����������Ƥ��ޤ�
	Cookie cookies[] = request.getCookies();

	/* for( int i = 0; cookies.length > i ; i++) {
		System.out.println("------------------");
		System.out.println(i);
		System.out.println(cookies[i].getName());
		System.out.println(cookies[i].getValue());
	} */

	//��Ū�Υ��å������Ǽ�����ѿ������
	Cookie accessTimeCookie = null;
	
	//���줾��Υ��å������Ф���̾�����ǧ
	//����ʤΤ���Ū��cookie��������뤿��ˤϳ�ǧ��ɬ��
	if( cookies != null ) {
		for(int i = 0; i < cookies.length; i++) {
			
			//̾����"accessTime"�Ǥ��뤫��ǧ
			//getName()�ǥ��å���̾���������ǽ
			if(cookies[i].getName().equals("accessTime")) {
				
				//������cookie�����
				accessTimeCookie = cookies[i];
				/* System.out.println(cookies[i].getName());
				System.out.println(cookies[i].getValue()); */				
			}
		}
	}
	
	
	//ɽ������ʸ����
	String accessTime;
	
	//�������륯�å��������Ĥ���ʤ��ä����
	if(accessTimeCookie == null ) {
		accessTime = "��Ͽ�ʤ�";
		
	//���å��������Ĥ��������ͤ������URL�ǥ����ɤ����
	//���Ĥ�����ǥ�����
	} else {
		accessTime = URLDecoder.decode(accessTimeCookie.getValue());
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
	<p>���å����μ���</p>
	<p>cookie.jsp �˺Ǹ�˥���������������<br>
	<b>[ <%= accessTime %> ]</b>
	
	<!-- ���Хѥ����� -->
	<p><a href="http://localhost:8080/exam/cookie.action">���å����򹹿�����</a></p>
	<p><a href="http://localhost:8080/exam/Cookie/cookie3.jsp">���å�����������</a></p>
</body>
</html>

 
