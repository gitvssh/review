<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>

<%
String title = request.getParameter("title");
String imgfile=request.getParameter("imgfile");
String content=request.getParameter("content");
%>

	<body bgcolor="orange" align="center">
		<font color="blue" size=20><%=title %></font>
		<br><br><hr><br>
		
		<img src="../imgs/<%=imgfile %>" width="300" height="300">
		<br><br>
		<hr>
		
		<font color="blue">2018년 09월 18일 대박세일 합니다<br>
		</font>
		<font>'<%=content%>'</font>
	</body>
</html>