<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="dto" class="boardre.BoardDto">
	<jsp:setProperty name="dto" property="*"/>
</jsp:useBean>

<%
boardre.BoardDao dao=new boardre.BoardDao();
dao.insertBoard(dto);
response.sendRedirect("List.jsp");
%>

