<%@page import="java.util.ArrayList"%>
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
 		int num = 10;
 		String str = "a";
 		ArrayList<String> list = new ArrayList<String>();
 		
 		public void jspMethod(){
 			System.out.println("--jspMethod()--");
 		}
 		%>
 		<!-- html 주석  -->
 		<%-- jsp주석 --%>
 		
 		<%
 		if(num>0){
 		%>
 		<p>num>0</p>
 		<%
 		} else {
 		%>
 		<p>num<=0</p>
 		<%
 		}
 		%>
 		
 		<%-- 표현식 태그 --%>
 		<p>num is <%=num %></p>
 		num is <%=num %>
	</body>
</html>	