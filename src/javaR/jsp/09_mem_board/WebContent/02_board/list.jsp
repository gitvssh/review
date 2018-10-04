<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="boardmysql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ include file="/view/color.jsp"%>

<%--list.jsp --%>

<%
request.setCharacterEncoding("utf-8");
%>
<%!
int pageSize=10;//페이지당 10개씩 표시 하려고
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>