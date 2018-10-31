<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
	<h2><center>글쓰기폼</center></h2>
	<form method="post" action="write" onSubmit="return writeFormCheck()">
		<table border="1" bgColor="margenta" width="60%">
			<tr>
				<td>글쓴이</td>
				<td><input type="text" id="writer" name="writer" size="10"/></td>
			</tr>
			<tr>
				<td>글제목</td>
				<td><input type="text" id="subject" name="subject" size="30"/></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" id="email" name="email" size="10"/></td>
			</tr>			
			<tr>
				<td>글내용</td>
				<td><textarea name="content" id="content" row="13" cols="40"></textarea></td>
			</tr>
			
			<tr>
				<td>암호</td>
				<td><input type="password" id="pwd" name="pwd" size="10"/></td>
			</tr>			
			
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="전송">
				<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>