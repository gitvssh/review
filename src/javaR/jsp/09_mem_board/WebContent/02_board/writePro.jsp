<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="boardmysql.*"%>

<%-- writePro.jsp --%>

<%
request.setCharacterEncoding("utf-8");
%>

<%--dto에 setter 작업 --%>
<jsp:useBean id="dto" class="boardmysql.BoardDTO">
	<jsp:setProperty name="dto" property="*"/>
</jsp:useBean>

<%
dto.setIp(request.getRemoteAddr());

boardmysql.BoardDAO dao = boardmysql.BoardDAO.getDao();//dao객체 얻기
dao.insertArticle(dto);//dao 메서드 호출
response.sendRedirect("list.jsp");//list.jsp 이동
%>