<%@ page 
	import="java.net.*"
	contentType="text/html; charset=euc-jp"
%>

<%
	//Cookieを使用する
	
	//目的のクッキー配列を取得
	//getCookies()は配列として全クッキーを取得してしまう
	Cookie cookies[] = request.getCookies();

	/* for( int i = 0; cookies.length > i ; i++) {
		System.out.println("------------------");
		System.out.println(i);
		System.out.println(cookies[i].getName());
		System.out.println(cookies[i].getValue());
	} */

	//目的のクッキーを格納する変数を準備
	Cookie accessTimeCookie = null;
	
	//それぞれのクッキーに対して名前を確認
	//配列なので目的のcookieを取得するためには確認が必要
	if( cookies != null ) {
		for(int i = 0; i < cookies.length; i++) {
			
			//名前が"accessTime"であるか確認
			//getName()でクッキー名前を取得可能
			if(cookies[i].getName().equals("accessTime")) {
				
				//該当のcookieを取得
				accessTimeCookie = cookies[i];
				/* System.out.println(cookies[i].getName());
				System.out.println(cookies[i].getValue()); */				
			}
		}
	}
	
	
	//表示する文字列
	String accessTime;
	
	//該当するクッキーが見つからなかった場合
	if(accessTimeCookie == null ) {
		accessTime = "記録なし";
		
	//クッキーが見つけた場合は値を取得（URLデコードする）
	//見つけたらデコード
	} else {
		accessTime = URLDecoder.decode(accessTimeCookie.getValue());
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
	<p>クッキーの取得</p>
	<p>cookie.jsp に最後にアクセスした時刻<br>
	<b>[ <%= accessTime %> ]</b>
	
	<!-- 絶対パス指定 -->
	<p><a href="http://localhost:8080/exam/cookie.action">クッキーを更新する</a></p>
	<p><a href="http://localhost:8080/exam/Cookie/cookie3.jsp">クッキーを削除する</a></p>
</body>
</html>

 
