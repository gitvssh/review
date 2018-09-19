<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>insert title here</title>
	</head>
	<body>
		<%!
		String adminId;
		String adminPw;
		
		String imgDir;
		String testServerIp;
		String realServerIp;
		%>
		
		<%
		adminId = config.getInitParameter("adminId");
		adminPw = config.getInitParameter("adminPw");
		%>
		
		<%
		imgDir = application.getInitParameter("imgDir");
		testServerIp = application.getInitParameter("testServerIp");
		
		%>
		
		<p>adminId : <%= adminId %></p> 
		<p>adminPw : <%= adminPw %></p> 
		<p>imgDir : <%= imgDir %></p> 
		<p>testServerIp : <%= testServerIp %></p>
		
		<%
		out.print("out객체 출력");
		%> 
	</body>
</html>	