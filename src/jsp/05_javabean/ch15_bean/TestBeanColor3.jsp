<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="mybean.*"
    %>
<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="cb" class="mybean.TestBeanColor3">
	<jsp:setProperty name="cb" property="*"/>
</jsp:useBean>

<%
if(request.getParameter("color")!=null){
%>
<jsp:getProperty name="cb" property="name"/>
	님이 좋아하는 색은
<font color='<jsp:getProperty name="cb" property="color"/>'>
<jsp:getProperty name="cb" property="color"/>
</font>입니다.
<%
}
%>
<br>
<br>
<%=cb.getName() %>
	님이 좋아하는 색은
<font color='<%=cb.getColor()%>'>
<%=cb.getColor()%>
</font>입니다.