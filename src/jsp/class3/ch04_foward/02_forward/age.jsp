<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- age.jsp --%>
<h2>age.jsp</h2>
<%
int age=Integer.parseInt(request.getParameter("age"));
%>

<%
if(age>0&&age<=10){
%>
<jsp:forward page="aa.jsp"/>
<%	
}else if(age>10&&age<=20){
%>
<jsp:forward page="bb.jsp"/>

<%	
}else if(age>20&&age<=60){
%>
<jsp:forward page="cc.jsp"/>

<%
}else if(age>60){
%>
<jsp:forward page="dd.jsp"/>

<%
}
%>