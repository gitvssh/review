<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/view/color.jspf" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>modifyPro.jsp</title>

<linke href="style.css" rel="stylesheet" type="text/css">

</head>
<body bgcolor="${bodyback_c}">
	<table width="270" border="0" cellspacing="0" cellpadding="5">
		<tr bgcolor="${title_c}">
			<td height="39" align="center">
				<font size="+1"><b>회원정보가 수정되었습니다.</b></font>
			</td>
		</tr>
		
		<tr>
			<td bgcolor="${value_c}" align="center">
				<p>입력하신 내용 수정이 완료되었습니다.</p>
			</td>
		</tr>
		
		<tr>
			<td bgcolor="${value_c}" align="center">
				<form>
					<input type="button" value="메인으로" onclick="document.location.href='${ctxpath}/member/main.do'">
				</form>
				3초후에 메인으로 이동합니다.
				<meta http-equiv="Refresh" content="3;url=${ctxpath}/member/main.do">
			</td>
		</tr>	
		
	</table>
</body>
</html>