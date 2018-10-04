<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>template.jsp</title>
</head>
<body>
<%
String contentPage=request.getParameter("contentPage");
%>

<table align="center" width="90%" height="500" border=3 bgColor="orange">

<tr>
	<td colspan="2" bgColor="margenta" height="10%">
		<jsp:include page="top.jsp" flush="flase"/>
		<%--flush는 출력버퍼 비우지 않는다. --%>
	</td>
</tr>

<tr>
	<td width="10%" valign="top" bgcolor="pink">
		<jsp:include page="left.jsp" flush="falase"/>
	</td>
	
	<td width="80%" valign="top">
		<jsp:include page="<%=contentPage %>" flush="false"/>
	</td>
</tr>

<tr>
<td colspan="2" bgcolor="lightGray" height="10%">
	<jsp:include page="bottom.jsp" flush="false"/>
</td>
</tr>
</table>
</body>
</html>