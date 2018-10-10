<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--Top.jsp--%>
<%
String admin_id=(String)session.getAttribute("admin_id");

if(admin_id==null){
	response.sendRedirect("AdminLogin.jsp");
}

String contxt=request.getContextPath();
%>
<table width="80%" align="center" bgcolor="#FFFF99">
	<tr bgcolor="#FFCC00">
		<td align="center"><b>
		<a href="<%= contxt%>/admin/Index.jsp">홈</a></b>
		</td>
		
		<td align="center"><b>
		<a href="<%= contxt%>/admin/AdminLogout.jsp">로그아웃</a></b>
		</td>
		
		<td align="center"><b>
		<a href="<%= contxt%>/admin/MemberMgr.jsp">회원관리</a></b>
		</td>
		
		<td align="center"><b>
		<a href="<%= contxt%>/admin/ProductList.jsp">상품관리</a></b>
		</td>
		
		<td align="center"><b>
		<a href="<%= contxt%>/admin/OrderMgr.jsp">주문관리</a></b>
		</td>
		
		
	</tr>
</table>