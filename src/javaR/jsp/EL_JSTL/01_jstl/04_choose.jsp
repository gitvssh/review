<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--04_choose.jsp--%>

<%--
choose 태그 : java의 switch-case 문과 유사하다.

choose 형식
<c:choose>
	<c:when test="${조건1}">
		조건이 참일때 처리할 내용
	</c:when>
	
	<c:when test="${조건2}">
		조건이 참일때 처리할 내용
	</c:when>
	
	<c:when test="${조건3}">
		조건이 참일때 처리할 내용
	</c:when>
	
	<c:otherwise>
		default 처리할 내용
	</c:otherwise>
</c:choose>
--%>

<h2>choose실습</h2>
<ul>
	<c:choose>
		<c:when test="${param.name=='park' }">
			<li>당신의 이름은 ${param.name }입니다<br>
		</c:when>
		
		<c:when test="${param.age>18 }">
			<li>당신은 ${param.age }살이며, 성인 입니다.<br>
		</c:when>
		
		<c:otherwise>
			<li>당신은 park 아니고 18살 이상도 아닙니다.
			<li>파라미터값이 없습니다.
		</c:otherwise>
	</c:choose>
</ul>