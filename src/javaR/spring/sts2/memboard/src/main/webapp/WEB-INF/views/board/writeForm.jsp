<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
background-color:yellow;
}
.list{
font-family:"맑은 고딕","돋움",sans-serif;
font-size:15px;
}
.list th{
border-top:2px solide #fbb9bb;
border-bottom:1px solid #d0d0d0;
padding:15px 0;
}
.list td{
border-bottom:1px solid #d0d0d0;
padding:10px 0;
}
.list a{
text-decoration:none;
color:#6c6c6c;
}
.list a:hover{
color:#f2216b;
}
</style>
</head>
<body>
	<h1 align="center">글쓰기 폼</h1>
	<form method="post" name="writeform" action="writePro.do">
		<input type="hidden" name="pageNum" value="${pageNum}">
		<input type="hidden" name="num" value="${num}">
		<input type="hidden" name="ref" value="${ref}">
		<input type="hidden" name="re_step" value="${re_step}">
		<input type="hidden" name="re_level" value="${re_level}">
		
		<table width="70%" border="1" cellspacing="0" cellpadding="0" align="center">
		
		<tr>
			<td align="right" colspan="2" bgcolor="#FFB4B4">
				<font class="list">
					<a href="list.do">글목록</a>
				</font>
			</td>
		</tr>
		
		<tr>
			<td width="70" bgcolor="#FFB4B4" align="center">이름</td>
			<td width="330">
				<input type="text" size="10" maxlength="10" name="writer">
			</td>
		</tr>
		
		<tr>
			<td bgcolor="#FFB4B4" align="center">제목</td>
			<td>
				<c:if test="${num==0}">
					<input type="text" size="40" maxlength="50" name="subject">
				</c:if>
				
				<c:if test="${num!=0}">
					<input type="text" size="40" maxlength="50" name="subject" value="[답변]">
				</c:if>
			</td>
		</tr>
		
		<tr>
			<td bgcolor="#FFB4B4" align="center">Email</td>
			<td>
				<input type="text" size="40" name="email">
			</td>
		</tr>
		
		<tr>
			<td bgcolor="#FFB4B4" align="center">내용</td>
			<td>
				<textarea name="content" rows="10" cols="40"></textarea>
			</td>
		</tr>
		
		<tr>
			<td bgcolor="#FFB4B4" align="center">비밀번호</td>
			<td>
				<input type="password" size="8" name="passwd">
			</td>
		</tr>
		
		<tr>
			<td colspan="2" bgcolor="#FFB4B4" align="center">
				<input type="submit" value="글쓰기">
				<input type="reset" value="다시작성">
				<input type="button" value="목록보기" onclick="document.location.href='list.do'">
			</td>
		</tr>
		</table>
	</form>
</body>
</html>