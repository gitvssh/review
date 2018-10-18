<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--03_test.jsp--%>
<%
request.setCharacterEncoding("utf-8");
%>
<h3>${sessionScope.id }님 환영합니다.</h3>

이름:${param.name}<br>
주소:${param.addr}<br>
전화:${param.tel}<br>

[취미]<br>
${paramValues.hobby[0]}<br>
${paramValues.hobby[1]}<br>
