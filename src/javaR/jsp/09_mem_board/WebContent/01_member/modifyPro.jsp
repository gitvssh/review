<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.*"
    %>
<%@ include file="/view/color.jsp" %>
    
<%
request.setCharacterEncoding("utf-8");

%>
<jsp:useBean id="dto" class="member.MemberDTO">
	<jsp:setProperty name="dto" property="*"/>
</jsp:useBean>

<html>
<body>
<%
String id=(String)session.getAttribute("memId");
dto.setId(id);

member.MemberDAO dao=member.MemberDAO.getInstance();
dao.updateMember(dto);
%>
<table bgcolor="<%=title_c%>">
	<tr>
		<td height="40" align="center">
		<font size="+2">
			<b>회원 정보 수정이 되었습니다.</b>
		</font>
		</td>
	</tr>
	
	<tr>
		<td bgcolor="<%=value_c %> align="center">
			<form>
				<input type="button" value="메인으로" onclick="window.location='main.jsp'">
			</form>
			
			3초 후에 메인으로 이동합니다.
			<meta http-equiv="Refresh" content="3.url=main.jsp">
		</td>
	</tr>
</table>
</body>
</html>