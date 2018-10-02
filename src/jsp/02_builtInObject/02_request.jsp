<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>02_request.jsp</title>
</head>
<body>
<%
String ip=request.getRemoteAddr();//클라링언트 ip 얻기
out.println(ip);
/*
if(ip.equals("192.168.0.5")){
	out.println("이 ip로는 접속할 수 없습니다");
	return;
}
*/
%>

<li> 메서드 방식:<%= request.getMethod()%>
<li> 요청 URI :<%= request.getRequestURI() %>
<li> 요청 URL :<%= request.getRequestURL() %>
<p>
<%--
요청 URI :/04_jsp/ch03/02_request.jsp 
요청 URL :http://localhost:9001/04_jsp/ch03/02_request.jsp 
--%>

<li>프로토콜 :<%=request.getProtocol() %><%--서버 HTTP/1.1 --%>
<li>서버이름 :<%=request.getServerName() %> 
<li>서버포트번호 :<%=request.getServerPort() %> <%--9001 --%>
<p>

<li>사용자 컴퓨터 주소:<%=request.getRemoteAddr() %><%--클라이언트 ip --%>
<li>사용자 컴퓨터이름 :<%= request.getRemoteHost() %><%--클라이언트 --%>




</body>
</html>