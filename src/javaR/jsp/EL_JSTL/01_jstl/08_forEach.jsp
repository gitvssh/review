<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--08_forEach.jsp--%>

<c:set var="map" value="<%=new HashMap() %>"/>

<c:set target="${map}" property="name" value="홍길동"/>
<c:set target="${map}" property="id" value="hong"/>
<c:set target="${map}" property="addr" value="서울 종로구"/>

<c:forEach var="m" items="${map }">
	<li>${m.key }==>${m.value }
</c:forEach>