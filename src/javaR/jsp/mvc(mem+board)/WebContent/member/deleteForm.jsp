<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/view/color.jspf" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="style.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
function begin(){
	document.myform.passwd.focus();
}

function checkIt(){
	if(!document.myform.passwd.value){
		alert("비밀번호를 입력하지 않았습니다.")
		document.myform.passwd.focus()
		return false;
	}
}
</script>
</head>
<body onload="begin()" bgcolor="${bodyback_c}">
	<form name="myform" action="${ctxpath}/member/deletePro.do" method="post" onSubmit="return checkIt()">
		<table cellspacing="1" cellpadding="1" width="260" border="1">
			<tr height="30">
				<td colspan="2" valign="middle" align="center" bgcolor="${title_c}">
					<font size="+1"><b>회원 탈퇴</b></font>
				</td>
			</tr>
			
			<tr height="30">
				<td width="110" bgcolor="${value_c}" align="center">비밀번호</td>
				<td width="150" align="center">
					<input type="password" name="passwd" size="15" maxlength="12">
					<input type="hidden" name="id" value="${sessionScope.memId }">
				</td>
			</tr>
			
			<tr height="30">
				<td colspan=2 align="center" valign="middle" bgcolor="${value_c}">
					<input type="submit" value="회원탈퇴">
					<input type="button" value="취소" onclick="document.location.href	='${ctxpath}/member/main.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>