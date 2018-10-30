<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
background-color: #ccdd99;
}
table{
line-height: 40px;
width: 80%;
}
#bb{
border:2px solid black;
background-color:#ccdd99;
}

</style>
</head>
<body>
	<center><h2>글내용보기</h2></center>
	<table>
		<tr>
			<td height="40px" align="center">
				<a href="edit.do?num=${boardDto.num}">글수정</a>&nbsp;
				<a href="delete.do?num=${boardDto.num}">글삭제</a>&nbsp;
				<a href="write.do">글쓰기</a>&nbsp;
				<a href="list.do">리스트</a>
			</td>
		</tr>
	</table>

	<table id="bb">
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
	
		<table>
		<tr>
			<td height="40px" align="center">
				<a href="edit.do?num=${boardDto.num}">글수정</a>&nbsp;
				<a href="delete.do?num=${boardDto.num}">글삭제</a>&nbsp;
				<a href="write.do">글쓰기</a>&nbsp;
				<a href="list.do">리스트</a>
			</td>
		</tr>
	</table>
</body>
</html>