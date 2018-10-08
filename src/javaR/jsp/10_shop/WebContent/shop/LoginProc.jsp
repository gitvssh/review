<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String mem_id=request.getParameter("mem_id");
String mem_passwd=request.getParameter("mem_passwd");

if(mem_id!=null||mem_id.length()>0){
	//DB작업후 인증
	session.setAttribute("mem_id",mem_id);
	
	response.sendRedirect("Index.jsp");
	//response.sendRedirect("GoodsList.jsp");
}
%>