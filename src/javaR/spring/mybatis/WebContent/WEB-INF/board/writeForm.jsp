<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--로그인에서 해야한다. --%>
<c:set var="userid" value="${sessionScope.id}"/>
<c:set var="userid" value="aaa"/>

<c:if test="${userid==null}">
	<script>
		alert("로그인 해야 글쓰기 할 수 있습니다.")
		location.href="login.do"
	</script>
</c:if>

<%--
//이전방ㅅ익
String userid=(String)session.getAttribute("id");
if(userid==null||userid.length()<1){
	%>
	<script>
		alert("로그인 해야 글쓰기 할 수 있습니다")
		location.href="login.do"
	</script>
	<%
}

--%>

<html>
<head>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function check(){
	if(jQuery("#writer").val()==null||$("#writer").val()==""){
		alert("글쓴이를 입력해주세요")
		jQuery("#writer").val('').focus();
		return false;
	}
	
	if($("#subject").val()==null||$("#subject").val()==""){
		alert("글 제목을 입력해주세요")
		$("#subject").focus();
		return false;
	}
	
	if($("#content").val()==null||$("#content").val()==""){
		alert("글 제목을 입력해주세요")
		$("#content").focus();
		return false;
	}
}//check()
</script>
</head>
<body bgcolor="#ccdd99">
<center><h2>게시판 글쓰기폼</h2></center>
<%=request.getServletContext().getContextPath() %>

<form method="post" action="write.do" onSubmit="return check()">
	<table border="2" bgcolor="#ccdd99" width="70%">
	
		<tr>
			<td>글쓴이</td>
			<td><input type="text" id="writer" name="writer" size="10"/></td>
		</tr>
	
		<tr>
			<td>글제목</td>
			<td><input type="text" id="subject" name="subject" size="30"/></td>
		</tr>
	
		<tr>
			<td>이메일</td>
			<td><input type="text" id="email" name="email" size="30"/></td>
		</tr>
	
		<tr>
			<td>글내용</td>
			<td><textarea name="content" id="content" rows="13" cols="40"></textarea></td>
		</tr>
	
		<tr>
			<td>암호</td>
			<td><input type="password" id="pwd" name="pwd" size="10"/></td>
		</tr>
	
		<tr>
			<td>ip</td>
			<td><input type="hidden" name="ip" value="<%=request.getRemoteHost() %>"/></td>
		</tr>
	
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="등록">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>