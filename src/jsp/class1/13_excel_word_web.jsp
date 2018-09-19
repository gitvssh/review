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
String type=request.getParameter("type");

if(type != null){
	if(type.equalsIgnoreCase("excel")){
		response.setContentType("application/vnd.ms-excel");
	}else if(type.equalsIgnoreCase("word")){
		response.setContentType("application/msword");
	}else{
		response.setContentType("text/html;charset=utf-8");
	}
}
%>
</body>
<table border="1">
	<tr>
	<th>이름</th><th>급여</th><th>주소</th>
	</tr>
	<tr>
	<td>고아라</td><td>250</td><td>강원 원주</td>
	</tr>
	<tr>
	<td>송혜교</td><td>350</td><td>서울 강남구</td>
	</tr>
	<tr>
	<td>송중기</td><td>350</td><td>강원 원고</td>
	</tr>
</table>
</html>