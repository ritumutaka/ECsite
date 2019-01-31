<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sss" uri="/struts-tags"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>buyComplete.jsp</title>
</head>
<body>
	<div id="bimg">
		<div id="bimg-mask">
			<jsp:include page="header.jsp" />
			<sss:if test='errorMessage == "noProblem"'>
				<h3>&lt;購入完了しました&gt;</h3>
			</sss:if>
			<sss:else>
				<h3>&lt;カートに商品がありません。&gt;</h3>
			</sss:else>

				<sss:form action="Sort">
					<table>
						<tr>
							<td><sss:submit value="ホームへ" /></td>
						</tr>
					</table>
				</sss:form>
		</div>
	</div>

</body>
</html>