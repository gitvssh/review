<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.*"
    %>
<%
String id=request.getParameter("id");
member.MemberDAO dao=member.MemberDAO.getInstance();

int check=dao.confirmId(id);
%>

{
 "check":<%= check %>
}