<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/view/color.jsp" %>
<%-- deleteForm.jsp--%>

<html>
<head>
	<script type="text/javascript">
	
	function begin(){
		document.delForm.passwd.focus();
	}
	
	function checkIt(){
		if(!document.delForm.passwd.value){
			alert("패스워드를 입력하세요");
			document.delForm.passwd.focus();
			return false;
		}
	}
	</script>
</head>
<body onload="begin()" bgcolor="<%=bodyback_c%>">
<form name="delForm" method="post" action="deletePro.jsp" onSubmit="return checkIt()">
	<table border="1" cellpadding="3" width="260" align="center">
		<tr height="30">
			<td colspan="2" valign="middle" align="center" bgcolor="<%=title_c %>">
			<font size="+2"><b>회원탈퇴</b></font>
			</td>
		</tr>
		
		<tr height="30">
			<td width="110" bgcolor="<%=value_c %>" align="center">
			비밀번호
			</td>
			
			<td width="150">
			<input type="password" name="passwd" size="15">
			</td>
		</tr>
		
		<tr height="30">
			<td colspan=2 align="center" valign="middle" bgcolor="<%=value_c %>">
				<input type="submit" value="회원탈퇴">
				<input type="button" value="취소" onclick="window.location='main.jsp'">
			</td>
		</tr>
	</table>
</form>
</body>
</html>