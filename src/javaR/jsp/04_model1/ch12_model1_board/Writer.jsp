<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wirte.jsp</title>

<style type="text/css">
	body{background-color:linen;}
	tr{line-height:30px;}
	textArea{resize:none;}
</style>

<script type="text/javascript">
function check(){
	
	//writer
	if(document.writeForm.writer.value==''){
		alert("이름을 입력하세요");
		document.writeForm.writer.focus();
		return false;
	}
	
	//subject
	if(document.writeForm.subject.value==''){
		alert("글 제목을 입력하세요");
		document.writeForm.subject.focus();
		return false;
	}
	
	//email
	if(document.writeForm.email.value==''){
		alert("email을 입력하세요");
		document.writeForm.email.focus();
		return false;
	}
	
	//content
	if(document.writeForm.content.value==''){
		alert("내용을 입력하세요");
		document.writeForm.content.focus();
		return false;
	}
	
	//pwd
	if(document.writeForm.pwd.value==''){
		alert("pwd을 입력하세요");
		document.writeForm.pwd.focus();
		return false;
	}
	
	document.writeForm.action="WriteSave.jsp";
	document.writeForm.submit();
}//function end
</script>
</head>
<body>

<table width="70%" align=center border="1" cellpadding="1" cellspacing="0">
	<tr>
		<td align="right">
			<a href="List.jsp">리스트</a>
		</td>
	</tr>
</table>

<form name="writeForm" method="post">

<table border=3 align=center width=70% bgColor="#ccc" cellpadding="2" cellspacing="0">
	<tr>
		<td colspan="2" align="center">
			<h3>(^.^)게시판 글쓰기(^.^)</h3>
		</td>
	</tr>
	
	<tr>
		<td>이름</td>
		<td align="left">
			<input type="text" name="writer" size=20>
		</td>
	</tr>
	
	<tr>
		<td>글제목</td>
		<td align="left">
			<input type="text" name="subject" size=20>
		</td>
	</tr>
	
	<tr>
		<td>이메일</td>
		<td align="left">
			<input type="text" name="email" size=30>
		</td>
	</tr>
	
	<tr>
		<td>글내용</td>
		<td align="left">
			<textarea name="content" rows="15" cols="40"></textarea>
		</td>
	</tr>
	
	<tr>
		<td>암호</td>
		<td align="left">
			<input type="password" name="pwd" size=20>
		</td>
	</tr>
	
	<tr>
	<td colspan="2" align="center">
		<input type="button" value="확인" OnClick="javaScript:check()">
		<input type="button" value="취소" OnClick="history.back()">
	</td>
	</tr>
</table>

</form>
</body>
</html>