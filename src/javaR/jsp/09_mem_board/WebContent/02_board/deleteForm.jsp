<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/view/color.jsp" %>
<%-- deleteForm.jsp --%>

<%
int num=Integer.parseInt(request.getParameter("num"));
String pageNum=request.getParameter("pageNum");
%>
<html>
<head>
	<link href="style.css" rel="stylesheet" type="text/css">
	<script src="//code.jqeury.com/jquery-3.3.1.min.js"></script>
	
	<script type="text/javascript">
		function deleteSave(){
			if($("#passwd").val()==""){
				alert("암호를 입력하세요")
				$("#passwd").focus()
				return false
			}
		}
	
	</script>
</head>

<body bgcolor="<%=bodyback_c %>">
	<center><b><font size="+2">글삭제</font></b></center>
	<form method="post" name="delForm" action="deletePro.jsp?pageNum=<%=pageNum %>" onSubmit="return deleteSave()">
		<table border="1" cellpadding="5" width="360" align="center">
			<tr height="30">
				<td align="center" bgcolor="<%=value_c %>">
				<b>암호를 입력하세요</b>
				</td>
			</tr>
			
			<tr height="30">
				<td align="center">비밀번호:
				<input type="password" name="asswd" id="asswd" size="8">
				<input type="hidden" name="num" value="<%=num %>">
			</tr>
			
			<tr height="30">
				<td align="center" bgcolor="<%=value_c %>">
					<input type="submit" value="글삭제">
					<input type="button" value="글목록" onclick="document.location='list.jsp?pageNum=<%=pageNum %>'">
				</td>
			</tr>
		</table>
	</form>
</body>

</html>