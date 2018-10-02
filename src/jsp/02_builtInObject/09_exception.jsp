<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="09_err.jsp" %>
<%--예외가 발생하면 09_err.jsp로 가서 메시지를 뿌리게 한다. --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>09_exception.jsp</title>
</head>
<body>
<%
int a=7;
int b=0;
%>

a+b=<%=a+b %><br>
a-b=<%=a-b %><br>
a*b=<%=a*b %><br>
a/b=<%=a/b %><br>
a%b=<%=a%b %><br>
</body>
</html>