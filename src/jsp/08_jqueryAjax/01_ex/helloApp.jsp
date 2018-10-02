<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.net.*"%>
<%--helloApp.jsp--%>

<%
//request.setCharacterEncoding("EUC-KR");
String name=URLDecoder.decode(request.getParameter("name"),"UTF-8");
%> 

<%--Ajax로 응답 --%>
<%=name%>님 안녕하세요