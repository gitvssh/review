<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="mail.*"
    import="com.oreilly.servlet.*"
    %>
<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="mailBean" class="mail.MailSender">
	<jsp:setProperty name="mailBean" property="*"/>
</jsp:useBean>

<%= mailBean.send()%>