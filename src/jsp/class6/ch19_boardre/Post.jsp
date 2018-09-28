<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Post.jsp</title>
<script type="text/javascript">
function check(){
	if(document.postForm.subject.value==''){
		alert("글제목을 입력하세요");
		document.postForm.subject.focus();
		return;
	}
	
	if(document.postForm.content.value==''){
		alert("글내용을 입력하세요");
		document.postForm.content.focus();
		return;
	}
	
	if(document.postForm.pass.value==''){
		alert("암호를 입력하세요");
		document.postForm.pass.focus();
		return;
	}
	
	document.postForm.submit();
}
</script>
</head>
<body bgcolor="ivory">
	<table width="80%" cellspacing="0" cellpadding="3" align="center">
		<tr>
			<td bgColor="#84f399" height="35" align="center">
				<b><font size=5>[[[글쓰기]]]</font></b>
			</td>
		</tr>
	</table>
	
	<br>
	<form name="postForm" method="post" action="PostProc.jsp">
		<table border="1" width="80%" cellspacing="0" cellpadding="3" align="center">
			<tr>
				<td width="10%">이름</td>
				<td width="90%">
					<input type="text" name="name" size=10>
				</td>
			</tr>
			<tr>
				<td>email</td>
				<td>
					<input type="text" name="email" size=30>
				</td>
			</tr>
			<tr>
				<td>homepage</td>
				<td>
					<input type="text" name="homepage" size=40 value="http://">
				</td>
			</tr>
			<tr>
				<td>subject</td>
				<td>
					<input type="text" name="subject" size=50>
				</td>
			</tr>
			<tr>
				<td>content</td>
				<td>
					<textArea name="content" rows="10" cols="50"></textArea>
				</td>
			</tr>
			<tr>
				<td>암호</td>
				<td>
					<input type="password" name="pass" size=15>
					<input type="hidden" name="ip" value="<%=request.getRemoteAddr()%>">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="글등록" onClick="check()">
					<input type="reset" value="다시쓰기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>