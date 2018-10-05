<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="boardmysql.*"%>
<%--updatePro.jsp--%>

<%
request.setCharacterEncoding("utf-8");
%>

<%--setter작업--%>

<jsp:useBean id="dto" class="boardmysql.BoardDTO">
	<jsp:setProperty name="dto" property="*"/>
</jsp:useBean>

<%
String pageNum=request.getParameter("pageNum");
BoardDAO dao=BoardDAO.getDao();
int check=dao.updateArticle(dto);
//check=1 정상수정
//check=0 암호틀림

if(check==1){// 정상수정
	response.sendRedirect("list.jsp?pageNum"+pageNum);
}else{//수정실패
%>
	<script>
		alert("비밀번호가 틀립니다");
		history.back();
	</script>
<%
}
%>