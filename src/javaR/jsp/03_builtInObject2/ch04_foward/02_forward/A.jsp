<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>A.jsp</title>
</head>
<body>
<h2>A.jsp</h2>
<%
String bloodType=request.getParameter("bloodType");
String name=request.getParameter("name");
%>

<b><%=name %></b>님의 혈액형은
<b><%=bloodType %></b>형이고
<br>
성실하고 신중하며 완벽 주의자 입니다
</body>
</html>