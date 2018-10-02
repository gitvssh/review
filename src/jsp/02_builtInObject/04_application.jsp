<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>04_application.jsp</title>
</head>
<body>
<%
out.println("서버정보<br>");
out.println(application.getServerInfo());
out.println("<br>");

out.println("aa.html MIME type 은 <br>");
out.println(application.getMimeType("aa.html"));
%>
<br>

 메이저 버전 :<%=application.getMajorVersion() %><br>
 마이너 버전 :<%=application.getMinorVersion() %><br>
 실제 경로 :<%=application.getRealPath("/") %><br>
 
 <%
 application.log("2017년 12월 29일 수당 아직 못받았는데 술먹고, 29일날 잠자는 사람 정모씨");
 %>
</body>
</html>