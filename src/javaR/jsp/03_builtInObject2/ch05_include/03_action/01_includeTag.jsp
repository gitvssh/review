<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>01_includeTag.jsp</h2>

<%
request.setCharacterEncoding("utf-8");
%>

01_includeTag.jsp 본문<br>
01_includeTag.jsp 본문<br>
01_includeTag.jsp 본문<br>
<jsp:include page="01_top.jsp"/>
01_includeTag.jsp 본문<br>
01_includeTag.jsp 본문<br>
01_includeTag.jsp 본문<br>
</body>
</html>