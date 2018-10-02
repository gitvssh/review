<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/view/color.jsp" %>

<%-- main.jsp --%>
<html>
<head>
<script type="text/javascript">
function focusIt(){
	document.inForm.id.focus()
}

function checkIt(){
	inputForm=eval("document.inForm")
	/*
	eval()함수
	1.인자로 받은 문자열이 숫자라면 실제로 숫자로 바뀐다
	
	2.인자로 받은 문자열의 내용이 자바스크립트가 인식할 수 있는 객체 형태라면
	문자열을 받아서 자바스크립트 객체로 리턴한다
	
	3.eval() 함수는 파싱도 한다.
	*/
	if(!inputForm.id.value){
		alert("아이디를 입력하세요")
		inputForm.id.focus()
		return false
	}
	if(!inputForm.passwd.value){
		alert("암호를 입력하세요")
		inputForm.passwd.focus()
		return false
	}
}
</script>
</head>
<body onload="focusIt()" bgcolor="<%=bodyback_c%>">
<%
if(session.getAttribute("memId")==null){//로그인 하지 않은 상태
%>
<form name="inForm" method="post" action="loginPro.jsp" onSubmit="return checkIt()">
	<table width="500" align="centeR" border="1">
		<tr>
			<td width="300" bgcolor="<%=bodyback_c %>" height="20">
			&nbsp;
			</td>
		
			<td bgcolor="<%=title_c %>" width="100" align="right">
				아이디
			</td>
			
			<td width="100" bgcolor="<%=value_c %>">
				<input type="text" name="id" size="15">
			</td>
			
		</tr>
		
		<tr>
			<td rowspan="2" width="300" bgcolor="<%=bodyback_c%>">
			&nbsp;
			</td>
			
			<td bgcolor="<%=title_c %>" width="100" align="right">
				패스워드
			</td>
			
			<td width="100" bgcolor="<%=value_c %>">
				<input type="password" name="passwd" size="15">
			</td>
		</tr>
		
		<tr>
			<td colspan="2" bgcolor="<%=title_c %>" align="center">
				<input type="submit" value="로그인">
				<input type="button" value="회원가입" onClick="javasScript:location='inputForm.jsp'">
			</td>
		</tr>
	</table>
</form>
<%	
}else{//로그인(회원정보수정, 로그아웃)
%>
<table width="900" height="90%" align="cener" border="1">
	<tr>
		<td width="60%" height="10%" bgcolor="<%=bodyback_c%>">
		반갑습니다.
		</td>
		
		<td width="40%" colspan="2" bgcolor="<%=value_c%>">
		<%
		String memId=(String)session.getAttribute("memId");
		%>
		
		<%=session.getAttribute("memId") %>님의 방문을 환영합니다<br>
		
		<form method="post" action="logout.jsp">
			<input type="submit" value="로그아웃">
			<input type="button" value="회원정보변경" onClick="javaScript:location='modify.jsp'">
		</form>
		</td>
	</tr>
	
	<tr>
		<td colspan="2" height="70%" bgcolor="<%=bodyback_c %>" width="300">
		메인입니다.
		</td>
	</tr>
</table>
<%	
}//else end----

%>
</body>
</html>