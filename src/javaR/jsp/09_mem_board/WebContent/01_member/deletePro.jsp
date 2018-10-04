<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.*"%>
<%@ include file="/view/color.jsp"%>

<%-- deletePro.jsp--%>

<%
request.setCharacterEncoding("utf-8");
String id=(String)session.getAttribute("memId");
String passwd=request.getParameter("passwd");

MemberDAO dao=MemberDAO.getInstance();
int check=dao.deleteMember(id,passwd);

if(check==1){//삭제 완료
	session.invalidate();
%>
	<body bgcolor="<%=bodyback_c%>">
	<form name="userInput" method="post" action="main.jsp">
		<table width="270" cellpadding="5" align="center">
			<tr bgcolor="<%=title_c%>">
				<td height="40" align="center">
				<font size="+2"><b>회원정보가 삭제 되었습니다.</b></font>
				</td>
			</tr>
			
			<tr bgcolor="<%=value_c%>">
				<td align="center">
					<p>Good Bye 잘가요.
					<meta http-equiv="Refresh" content="3;url=main.jsp">
				</td>
			</tr>
			
			<tr bgcolor="<%= value_c%>">
				<td align="center">
				<input type="submit" value="확인">
				</td>
			</tr>
			
			
		</table>
	</form>
	</body>
<%
}else if(check==-1){//암호 틀림
%>
	<script>
		alert("비밀번호가 틀립니다")
		history.back()
	</script>
<%	
}else if(check==0){//존재하지 않음
%>
	<script>
		alert("존재하지 않음")
		history.back()
	</script>
<%	
	
}
%>