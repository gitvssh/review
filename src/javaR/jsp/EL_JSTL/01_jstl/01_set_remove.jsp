<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--01_set_remove.jsp--%>

<%--
변수선언 형식
<c:set var="변수이름" value="정수,실수,문자열" scope=""/>
scope를 생략하면 디폴트는 page이다
--%>

<c:set var="num1" value="${20 }" scope="page"/>
<c:set var="num2" value="${30 }"/>

<c:set var="num3" scope="page">
12.3
</c:set>

<c:set var="date" value="<%= new java.util.Date() %>"/>
num1:${pageScope.num1}<br>
num2:${pageScope.num2}<br>
num3:${pageScope.num3}<br>
date:${pageScope.date}<br>

연산:${num1+num2+num3}<br>

변수제거:remove<br>
<c:remove var="num1" scope="page"/>
num1:${num1}