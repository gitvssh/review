<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><center>게시판리스트</center></h1>
<table border="1">
	<c:forEach var="dto" items="${list}">
		<tr>
			<td align="center">${dto.writer}</td>
			<td align="left">
				<a href="content.do?num=${dto.num}">${dto.subject}</a>
			</td>
			<td align="right">${dto.email}</td>
			<td align="right">${dto.wdate}</td>
			<td align="right">${dto.readcount}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>