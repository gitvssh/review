<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/view/color.jsp"%>
<%-- writeForm.jsp --%>

<%
request.setCharacterEncoding("utf-8");//post요청 한글 처리
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">

<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="script.js"></script>
</head>
<%
int num=0;//변수
int ref=1;//그룹글
int re_step=0;//글 순서 정리
int re_level=0;//글 깊이 depth
String regdate="";//날짜

if(request.getParameter("num")!=null){//답글이면
	num=Integer.parseInt(request.getParameter("num"));
	ref=Integer.parseInt(request.getParameter("ref"));
	re_step=Integer.parseInt(request.getParameter("re_step"));
	re_level=Integer.parseInt(request.getParameter("re_level"));
}
%>
<body bgcolor="<%=bodyback_c%>">
	<center><h2>글쓰기, 답글쓰기</h2></center>
	<form name="writeform" method="post" action="writePro.jsp" onsubmit="return writeSave()">

	<input type="hidden" name="num" value="<%= num %>">
	<input type="hidden" name="ref" value="<%= num %>">
	<input type="hidden" name="re_step" value="<%= re_step %>">
	<input type="hidden" name="re_level" value="<%= re_level %>">
	
	<table width='500' cellpadding="3" bgcolor="<%=bodyback_c %>" algin="center">
		
		<tr>
			<td colspan="2" align="right" bgcolor="<%=value_c %>">
			<a href="list.jsp">글목록</a>
			</td>
		</tr>
	
		<!--  이름 -->
		<tr bgcolor="<%=value_c %>">
			<td width="70" bgcolor="<%=value_c %>">이름</td>
			<td width="330">
			<input type="text" name="writer" id="writer" size="10">
			</td>
		</tr>
		
		<!--  글제목 -->
		<tr bgcolor="<%=value_c %>">
			<td bgcolor="<%=value_c %>">글제목</td>
			<td>
			<%
			if(request.getParameter("num")==null){
			%>
				<input type="text" name="subject" id="subject" size="40">
			<%
			}else{
			%>
				<input type="text" name="subject" id="subject" size="40" value="[답글]">
			<%
			}
			%>
		</tr>
		
		<!-- email -->
		<tr bgcolor="<%=value_c%>">
			<td bgcolor="<%=value_c%>">이메일</td>
			<td>
				<input type="text" name="email" id="email" size="30">
			</td>
		</tr>
		
		<!-- 글내용 -->
		<tr bgcolor="<%=value_c%>">
			<td bgcolor="<%=value_c%>">글내용</td>
			<td>
				<textarea id="content" name="content" rows="10" cols="40"></textarea>
			</td>
		</tr>
		
		<!-- 비밀번호 -->
		<tr bgcolor="<%=value_c%>">
			<td bgcolor="<%=value_c%>">비밀번호</td>
			<td>
				<input type="password" name="passwd" id="passwd" size="12">
			</td>
		</tr>
		
		<tr bgcolor="<%=value_c%>">
			<td colspan="2" align="center" bgcolor="<%=value_c %>">
				<input type="submit" value="글쓰기">
				<input type="reset" value="다시쓰기">
				<input type="button" value="글목록" onclick="window.location='list.jsp'">				
			</td>
		</tr>
		
		
	</table>
	</form>
</body>
</html>