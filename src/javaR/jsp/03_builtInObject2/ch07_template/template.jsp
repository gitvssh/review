<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--template.jsp --%>
<%
String control=request.getParameter("control");
String contentPage=request.getParameter("contentPage");
String pageTitle=request.getParameter("pageTitle");
String left=control+"left.jsp";

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>MyHome Page</h1>
	
<table width="90%" height="95" align="center" bgColor="margenta" border="1" cellpadding="2" cellspacing="0">
	<%-- top메뉴 --%>
	<tr>
		<td colspan="2" height="10%">
			<font size="3">
				<jsp:include page="top.jsp" flush="false"/>
			</font>
		</td>
	</tr>
	<tr>
	<%--왼쪽메뉴 --%>
		<td width="100" valign="top">
			<jsp:include page="<%=left %>" flush="false"/>
		</td>
	<%--중앙에 표시 --%>
		<td width="450" valign="top">
			<jsp:include page="<%=contentPage%>" flush="false"/>
		</td>
	</tr>
	
	<tr>
	<td colspan="2" height="10%">
		<jsp:include page="bottom.jsp" flush="false"/>
	</td>
	</tr>
</table>
</body>
</html>