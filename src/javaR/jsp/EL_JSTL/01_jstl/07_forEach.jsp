<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="dao.*"%>
<%@ page import="java.util.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--07_forEach.jsp--%>

<%
TestDao dao=new TestDao();
%>

<c:set var="list" value="<%=dao.getList()%>"/>

<c:forEach var="dto" items="${list}">
	${dto.name }<br>
	${dto.pwd }<br>
	${dto.email }<br><br>
</c:forEach>