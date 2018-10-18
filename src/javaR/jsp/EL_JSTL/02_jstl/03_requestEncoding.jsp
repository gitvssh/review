<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--03_requestEncoding.jsp--%>

<fmt:requestEncoding value="utf-8"/>

<%
//request.setCharacterEncoding("utf-8");
%>

out 태그는 웹으로 출력하는 태그입니다<br>

<c:out value="out태그는 웹으로 출력하는 태그"/>

<br>
파라미터값 :<c:out value="${param.name }"/><br>
파라미터값 : ${param.name }<br>

<form method="post" action="03_requestEncoding.jsp">
	<input type="text" name="name" value="">
	<input type="submit" value="전송">
</form>

