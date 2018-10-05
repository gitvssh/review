<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--content.jsp--%>

<%@ page import="boardmysql.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ include file="/view/color.jsp" %>

<%-- content.jsp --%>

<html>
<head>
	<link href="style.css" rel="stylesheet" type="text/css">
</head>

<%
int num=Integer.parseInt(request.getParameter("num"));
String pageNum=request.getParameter("pageNum");
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

BoardDAO dao=BoardDAO.getDao();
BoardDTO dto=dao.getArticle(num);

int ref=dto.getRef();
int re_step=dto.getRe_step();
int re_level=dto.getRe_level();
%>

<body bgcolor="<%=bodyback_c%>">
<center><h1>글내용보기</h1></center>

<table width="500" border="1" cellpadding="3" align="center" bgcolor="<%=bodyback_c %>">

	<tr height="30">
		<td align="center" width="125" bgcolor="<%=value_c %>">글번호</td>
		<td align="center" width="125"><%=dto.getNum() %></td>
		
		<td align="center" width="125" bgcolor="<%=value_c %>">조회수</td>
		<td align="center" width="125"><%=dto.getReadcount() %></td>
	</tr>
	
	<tr height="30">
		<td align="center" width="125" bgcolor="<%=value_c %>">작성자</td>
		<td align="center" width="125"><%=dto.getWriter() %></td>
		
		<td align="center" width="125" bgcolor="<%=value_c %>">작성일</td>
		<td align="center" width="125"><%=sdf.format(dto.getRegdate()) %></td>
	</tr>

	<tr height="30">
		<td align="center" width="125" bgcolor="<%=value_c %>">글제목</td>
		<td align="center" width="125" colspan="3"><%=dto.getSubject() %></td>
	</tr>
	
	<tr height="30">
		<td align="center" width="125" bgcolor="<%=value_c %>">글내용</td>
		<td align="center" width="125" colspan="3" bgcolor="<%=value_c %>">
		<%
		String im=dto.getContent();
		im=im.replace("\n,","<br>");
		%>
		<%=im %>
		</td>
	</tr>
	
	<tr height="30">
		<td colspan="4" bgcolor="<%=value_c %>" align="right">
		<input type="button" value="글수정"
		onclick="document.location.href='updateForm.jsp?num=<%=dto.getNum() %>&pageNum=<%=pageNum %>'">
		
		<input type="button" value="글삭제"
		onclick="document.location.href='deleteForm.jsp?num=<%=dto.getNum() %>&pageNum=<%=pageNum %>'">
		
		<input type="button" value="답글쓰기"
		onclick="document.location.href='writeForm.jsp?num=<%=dto.getNum() %>&pageNum=<%=pageNum %>&ref=<%=ref%>&re_step=<%=re_step%>&re_level=<%=re_level%>'">
		
		<input type="button" value="리스트"
		onclick="document.location.href='list.jsp?pageNum=<%=pageNum %>'">
		
	</tr>
</table>

</body>
</html>
