<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="#ccdd99">
<table border="1" width="80%" bgColor="#ccdd99">
	<tr>
		<td colspan="4" align="center">
			<font size="5">게시판0리스트</font>
		</td>
		<td align="right">
			<a href="write.do">글쓰기</a>
		</td>
	</tr>
	
	<tr height="40">
		<th align="center">글쓴이</th>
		<th align="left">글제목</th>
		<th align="right">이메일</th>
		<th align="right">날짜</th>
		<th align="right">조회수</th>
	</tr>
	
	<c:forEach var="boardDto" items="${list}">
		<tr height="40">
			<td align="center">${boardDto.writer}</td>
			
			<td align="left">
				<a href="content.do?num=${boardDto.num}">
				${boardDto.subject}</a>
			</td>
			
			<td align="right">${boardDto.email}</td>
			<td align="right">${boardDto.wdate}</td>
			<td align="right">${boardDto.readcount}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>