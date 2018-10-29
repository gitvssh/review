<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
function writeSave(){
	if(document.writeform.writer.value==''){
		alert("이름을 입력하세요")
		document.writeform.writer.focus()
		return false
	}
	if(document.writeform.subject.value==''){
		alert("제목을 입력하세요")
		document.writeform.subject.focus()
		return false
	}
	if(document.writeform.content.value==''){
		alert("글내용을 입력하세요")
		document.writeform.content.focus()
		return false
	}
	if(document.writeform.pwd.value==''){
		alert("비밀번호을 입력하세요")
		document.writeform.pwd.focus()
		return false
	}
	document.writeform.action="write.do"
	document.writeform.submit()
}
</script>
</head>
<body>
<center><h2>게시판 글쓰기</h2></center>

<table align="center" width="407">
	<tr>
		<td align="right">
			<a href="list.do?page=1">리스트</a>
		</td>
	</tr>
</table>
<form  name="writeform" method="post"><br>
	<table border="10" align="center" width="407" bgcolor="margenta" cellpadding="1" cellspacing="1">
		<tr height="40px">
			<td>글쓴이</td>
			<td>
			<input type="text" id="writer" name="writer" maxlength="20"/>
			</td>
		</tr>
		
		<tr>
			<td>제목</td>
			<td>
			<input type="text" id="subject" name="subject" size="40" maxlength="40"/>
			</td>
		</tr>
		
		<tr>
			<td>이메일</td>
			<td>
			<input type="text" id="email" name="email" size="30" maxlength="30"/>
			</td>
		</tr>
		
		<tr>
			<td>글내용</td>
			<td>
				<textarea id="content" name="content" rows="13" cols="40"></textarea>
			</td>
		</tr>
		
		<tr>
			<td>비밀번호</td>
			<td>
			<input type="password" id="pwd" name="pwd" size="20" maxlength="20"/>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="확인" onclick="javascript:writeSave()">
				<input type="button" value="취소" onclick="history.back()">
			</td>
		</tr>
		
		
	</table>
</form>

</body>
</html>