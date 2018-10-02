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
JspWriter out2=pageContext.getOut();
out2.print("2018년 09월 19일");
%>

요청 객체:<%=pageContext.getRequest() %><br>
세션 객체:<%=pageContext.getSession() %><br>
예외 객체:<%=pageContext.getException() %>
</body>
</html>