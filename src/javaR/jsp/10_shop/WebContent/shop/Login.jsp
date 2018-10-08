<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
response.setCharacterEncoding("utf-8");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="style.css" rel="stylesheet" type="text/css">
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="script.js"></script>

</head>
<body bgcolor="#99600" topmargin="100">
<%@ include file="Top.jsp" %>
<tr bordercolor="#FFFF99">
	<td height="190">
		<form method="post" name="login" action="LoginProc.jsp">
			<table width="50" border="1" align="center">
			
			<tr bordercolor="#FFFF66">
				<td colspan="2" align="center">로그인</td>
			</tr>
		
			<tr>
				<td width="47%" align="center">ID</td>
				<td width="53%" align="center">
				<input type="text" name="mem_id" id="mem_id">
				</td>
			</tr>
		
			<tr>
				<td align="center">PWD</td>
				<td align="center">
				<input type="password" name="mem_passwd" id="mem_passwd">
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="login" onClick="loginCheck()">
					&nbsp;&nbsp;
					<input type="reset" value="reset">
				</td>
			</tr>
			</table>
		</form>
	</td>
</tr>
<%@ include file="Bottom.jsp" %>
</body>
</html>