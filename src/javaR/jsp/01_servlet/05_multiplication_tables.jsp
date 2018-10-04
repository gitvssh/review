<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<%
int i,j=0;
for(i=1;i<10;i++){
	out.println("<tr>");
	if(i==1){
	out.println("<td>구구단</td>");
	}else{
	out.println("<td>"+i+"단</td>");
	}
	
	for(j=1;j<10;j++){
		if(i==1){
		out.println("<td>&nbsp; * "+j+"</td>");
		}else{
		out.println("<td align=center>"+i*j+"</td>");
		}
	}
	out.println("</tr>");
}
%>
</table>
</body>
</html>