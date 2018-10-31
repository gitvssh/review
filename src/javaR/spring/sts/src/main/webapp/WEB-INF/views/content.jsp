<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
table{
width:70%;
line-height:40px;
}
</style>
<body>
	<h2><center>글내용보기</center></h2>
	<table align="center">
		<tr>
			<td height="40px" align="center">
				<a href="edit?num=${boardDto.num}">글수정</a>&nbsp;
				<a href="delete?num=${boardDto.num}">글삭제</a>&nbsp;
				<a href="writeForm">글쓰기</a>&nbsp;
				<a href="list">리스트</a>
			</td>
		</tr>
	</table>
	
	<table border="1" bgcolor="margenta" align="center">
		<tr>
			<td>글쓴이</td>
			<td>${boardDto.writer}</td>
		</tr>
		<tr>
			<td>글제목</td>
			<td>${boardDto.subject}</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${boardDto.email}</td>
		</tr>
		<tr>
			<td>글내용</td>
			<td>${boardDto.content}</td>
		</tr>
	</table>
</body>
</html>