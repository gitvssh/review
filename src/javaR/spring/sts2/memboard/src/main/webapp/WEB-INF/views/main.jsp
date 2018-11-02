<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
main.jsp

<a href="list.do">게시판</a>&nbsp;
<a href="insertForm.do">회원가입</a>&nbsp;

<c:if test="${id==null}">
	<a href="login.do">로그인</a>
</c:if>

<c:if test="${id!=null}">
	<a href="logOut.do">로그아웃</a>
</c:if>


</body>
</html>