<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>주석</h1>
<h2>html주석 될 수 있으면 사용하지 마세요</h2>
	<h2>html 주석 html코드 부분에서만 사용하세요</h2>
	
	<!-- 
	html주석, 소스보기에서 보인다, 자바 문법이 틀리면 에러가 나온다.
	 -->
	 
	 <h1>jsp주석 소스보기에서 안보인다.</h1>
	 <%-- jsp주석 --%>
	 
	 <%
	 out.println("<h1>java 주석임</h1>");
	 //엄마리신이랑 아들리신이 궁쓰면?? ㅋㅋ
	 %>
</body>
</html>