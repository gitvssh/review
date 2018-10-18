<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--03_iftag.jsp--%>

<%--
<c:if test="조건">
 	조건이 참일때 실행<br>
</c:if>
--%>

<c:if test="${true }">
	무조건 실행<br>
	무조건 실행<br>
	무조건 실행<br>
</c:if>

<c:if test="${param.name=='park' }">
	${param.name }님 환영합니다.<br>
</c:if>

<%--
http://localhost:9001/12_JSTL/01_jstl/03_iftag.jsp?&name=park
--%>

<c:if test="${param.age>18}">
	당신의 나이는 ${param.age }살이며, 성인입니다.
</c:if>

<%--
http://localhost:9001/12_JSTL/01_jstl/03_iftag.jsp?&name=park&age=27
--%>