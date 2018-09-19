<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer="10kb"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>01_out.jsp</title>
</head>
<body>
<h2>01_out.jsp</h2>
<%
int total=out.getBufferSize();//전체 버퍼 8kb
int rate=out.getRemaining();//남아있는 버퍼
%>

전체 버퍼:<%= total%><br>
남아있는 버퍼:<%= rate %><br>
사용중인 버퍼 :<%= total-rate%>

<br>
<%
out.println("전체버퍼:"+total+"<br>");
%>

</body>
</html>