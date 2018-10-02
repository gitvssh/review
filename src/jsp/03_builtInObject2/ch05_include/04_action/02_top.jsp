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
String id=request.getParameter("id");
String pwd=request.getParameter("pwd");

String name=request.getParameter("name");
String addr=request.getParameter("addr");
String tel=request.getParameter("tel");
%>

<h2>02_top.jsp 처리결과</h2>
ID:<%=id %><br>
PWd:<%=pwd %><br>
이름:<%=name %><br>
주소:<%=addr %><br>
전화:<%=tel %><br>

</body>
</html>