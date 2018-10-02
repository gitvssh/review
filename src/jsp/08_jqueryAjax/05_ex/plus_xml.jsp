<?xml version="1.0" encoding="EUC-KR"?>
<%@ page language="java" contentType="application/xml"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>

<%
int op1=Integer.parseInt(request.getParameter("op1"));
int op2=Integer.parseInt(request.getParameter("op2"));
int result=op1+op2;
%>

<data>
  <op1 value="<%=op1%>"/>
  <op2 value="<%=op2%>"/>
  <result value="<%=result%>"/>
</data>
