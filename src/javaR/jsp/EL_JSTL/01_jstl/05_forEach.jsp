<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--05_forEach.jsp--%>

<%--
forEach 태그는 배열이나, Collection, Map에 저장된
값들을 순차적으로 처리할 때 사용
자바의 for문이나 while, do-while등을
대신해서 사용할 수 잇다.

형식

<c:forEach var="변수" items="아이템">
	처리내용
</c:forEach>
--%>

<h3>1~10까지 출력하기</h3>

<c:forEach var="i" begin="1" end="10" step="1">
	${i}&nbsp;
</c:forEach>

<h3>1~10까지 합 구하기</h3>
<c:set var="sum" value="0"/>

<c:forEach var="i" begin="1" end="10">
	<c:set var="sum" value="${sum+i }"/>
</c:forEach>

합출력 : ${sum}