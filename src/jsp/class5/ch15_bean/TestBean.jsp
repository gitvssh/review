<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="mybean.*"
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="tb" class="mybean.TestBean">
	<jsp:setProperty name="tb" property="id" value="kim"/>
	<jsp:setProperty name="tb" property="pwd" value="kim123"/>
	<jsp:setProperty name="tb" property="name" value="김길동"/>
	
	ID:<jsp:getProperty name="tb" property="id"/><br>
	PWD:<jsp:getProperty name="tb" property="pwd"/><br>
	이름:<jsp:getProperty name="tb" property="name"/><br>
</jsp:useBean>

<%
	tb.setId("ppp");
	tb.setPwd("ppp123");
	tb.setName("박문수");
%>
ID:<%=tb.getId() %><br>
PWD:<%=tb.getPwd()%><br>
이름:<%=tb.getName() %><br>
</body>
</html>