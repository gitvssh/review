<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.*"%>

<%-- loginPro.jsp --%>

<%
request.setCharacterEncoding("utf-8");
String id=request.getParameter("id");
String passwd=request.getParameter("passwd");

member.MemberDAO dao=member.MemberDAO.getInstance();
int check=dao.userCheck(id,passwd);

if(check==1){
	session.setAttribute("memId",id);
	response.sendRedirect("main.jsp");
}else if(check==0){
%>
<script>
	alert("비밀번호가 틀립니다.")
	history.back();
</script>
<%	
}else{
%>
	<script>
	alert("아이디가 틀립니다.")
	history.back();
	</script>
<%	
}

%>
