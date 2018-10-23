<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/view/color.jspf" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="style.css" rel="stylesheet" type="text/css">

</head>
<body bgcolor="${bodyback_c}">
	<c:if test="${check==1}">
		<c:remove var="memId" scope="session"/>
		
		<table width="270" cellpadding="5">
			<tr bgcolor="${title_c }">
				<font size="+1"><b>탈퇴 되었습니다.</b></font>
			</tr>
			
			<tr bgcolor="${value_c}">
				<td align="center">
					<p>안녕히 가세요</p>
					<meta http-equiv="Refresh" content="2;url=${ctxpath}/member/main.do">
				</td>
			</tr>
		</table>	
	</c:if>
	
	<c:if test="${check==0}">
		<script>
			alert("비밀번호가 틀립니다")
			history.go(-1)
		</script>
	</c:if>
</body>
</html>