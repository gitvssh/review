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
request.setCharacterEncoding("utf-8");
%>
02_includeTag.jsp 본문<br>
02_includeTag.jsp 본문<br>
<hr color="red">
	<jsp:include page="02_top.jsp">
		<jsp:param name="addr" value="서울시 서대문구"/>
		<jsp:param name="tel" value="0101-111-2222"/>
		<jsp:param name="name" value="박문수"/>
	</jsp:include>
<hr color="red">
02_includeTag.jsp 본문<br>
02_includeTag.jsp 본문<br>
</body>
</html>