<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="mybean.*"
    %>
    
<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="tb2" class="mybean.TestBean2">
	<jsp:setProperty name="tb2" property="*"/>
</jsp:useBean>


이름:<%=tb2.getName() %><br>
ID:<%=tb2.getId() %><br>
주소:<%=tb2.getAddr() %><br>
전화:<%=tb2.getTel() %><br>
글내용:<%=tb2.getContent() %><br>