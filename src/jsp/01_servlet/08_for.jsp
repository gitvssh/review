<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
String name[]={
		"January","February","March","Aprill","May","June","July","August",
		"September","October","November","December"
};
%>
<table border=1>
<%
for(int i=0;i<name.length;i++){
%>
<tr>
	<td><%=i+1 %>&nbsp;</td>
	<td><%=name[i] %>&nbsp;</td>
<%
}
%>
</table>
</body>
</html>