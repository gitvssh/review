<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table align="center" width="407">
	<tr>
		<td align="right">
			<a href="write.do">글쓰기</a>
		</td>
	</tr>
</table>
	<table border="1">
		<tr bgcolor="cyan" height="26">
			<td width="50">번호</td>
			<td width="130">제목</td>
			<td width="75">작성자</td>
			<td width="103">작성일</td>
			<td width="103">조회</td>
		</tr>
		
		<c:forEach var="board" items="${boardList}">
			<tr>
				<td align="left">${board.num }</td>
				
				<td>
					<a href="content.do?num=${board.num }">
					${board.subject }
					</a>
				</td>
				
				<td>${board.writer }</td>
				
				<td><fmt:formatDate value="${board.wdate }" type="date"/></td>
				
				<td>${board.readcount }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>