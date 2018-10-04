<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

String name = request.getParameter("이름");
String id = request.getParameter("id");
String pwd=request.getParameter("pwd");
%>
<h2>당신이 입력한 정보입니다.</h2>
이름:<%=name %>
id:<%=id %>
pwd:<%=pwd %>
</body>
</html>