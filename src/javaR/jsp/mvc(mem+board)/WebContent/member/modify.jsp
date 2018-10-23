<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/view/color.jspf"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">

</head>
<body bgcolor="${bodyback_c}">
	<table width="500">
		<tr>
			<td>
				<form name="modifyForm" method="post"
					action="${ctxpath}/member/modifyForm.do">
					<input type="hidden" name="id" value="${sessionScope.memId}">
					<input type="submit" value="회원정보 수정">
				</form>
			</td>
			
			<td>
				<form name="deleteForm" method="post"
					action="${ctxpath}/member/deleteForm.do">
					<input type="hidden" name="id" value="${sessionScope.memId}">
					<input type="submit" value="회원 탈퇴">
				</form>
			</td>
			
			<td>
				<form name="myform" action="${ctxpath}/member/main.do" method="post">
					<input type="submit" value="메인으로">
				</form>
			</td>
		</tr>
	</table>
</body>
</html>