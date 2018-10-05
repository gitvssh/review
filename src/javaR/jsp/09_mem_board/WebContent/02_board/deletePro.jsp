<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="boardmysql.*"%>

<%-- deletePro.jsp--%>
<%
request.setCharacterEncoding("utf-8");

int num=Integer.parseInt(request.getParameter("num"));
String pageNum=request.getParameter("pageNum");
String passwd=request.getParameter("passwd");

BoardDAO dao=BoardDAO.getDao();
int check=dao.deleteArticle(num,passwd);

if(check==1){
	response.sendRedirect("list.jsp?pageNum="+pageNum);
}else{
	%>
	<script>
		alert("비밀번호가 맞지 않습니다")
		history.back()
	</script>
	<%
}
%>