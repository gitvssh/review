<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="boardre.*"
    %>
<%
request.setCharacterEncoding("utf-8");
boardre.BoardDao dao=new boardre.BoardDao();
%>

<%
int nowPage=Integer.parseInt(request.getParameter("page"));//글내용보기에서 넘어온 값
int num=Integer.parseInt(request.getParameter("num"));

BoardDto dto=dao.getBoard(num);//dao 메서드 호출

String subject=dto.getSubject();
String name=dto.getName();
String content=dto.getContent();
String email=dto.getEmail();
String homepage=dto.getHomepage();
%>
<html>
<head>
	<script type="text/javascript">
	function check(){
		if(document.editForm.pass.value==""){
			alert("암호를 입력하세요");
			document.editForm.pass.focus();
			return false;
		}
		document.editForm.submit();//서버로 전송
	}//check()
	</script>
</head>
<body bgcolor="#B5A642" align=center>
	<table width="70%" cellspacing=0 cellpadding=3 align=center>
		<tr>
		<td bgcolor="#ff9018" height=21 align=center>
		<font size=7>글 수정하기</font>
		</td>
		</tr>
		
	</table>
	
	<form name="editForm" method="post" action="UpdateProc.jsp">
		<table width="70%" cellspacing="0" cellpadding=7 align=center border=10 borderColor="margenta">
		<tr>
			<td align="center">
				<table border=0>
					<tr>
						<td width=20%>이름</td>
						<td width="80%">
						<input type="text" name="name" value="<%=name %>" size="20">
						</td>
					</tr>
					
					<tr>
						<td>이메일</td>
						<td>
							<input type="text" name="email" value="<%=email %>" size="30">
						</td>
					</tr>
					
					<tr>
						<td>홈페이지</td>
						<td>
							<input type="text" name="homepage" value="<%=homepage %>" size="30">
						</td>
					</tr>
					
					<tr>
						<td>제목</td>
						<td>
						<input type="text" name="subject" value="<%=subject %>" size="50">
						</td>
					</tr>
					
					<tr>
						<td>글내용</td>
						<td>
							<textarea name="content" rows="10" cols="50"><%=content %></textarea>
						</td>
					</tr>
					
					<tr>
						<td>암호</td>
						<td>
						<input type="password" name="pass" size="150">
						<font color="red">수정시에는 암호가 필요합니다.</font>
						</td>
					</tr>
					
					<tr>
					<td colspan=2>
					<hr>
					</tr>
					
					<tr>
						<td colspan="2" align="center">
							<input type="button" value="수정" onclick="check()">
							<input type="reset" value="다시수정하기">
							<input type="button" value="뒤로" onclick="history.go(-1)">
							
							<input type="hidden" name="num" value="<%=num %>">
							<input type="hidden" name="page" value="<%=nowPage %>">
						</td>
					</tr>
				</table>
			</td>
		</tr>
		</table>
	</form>
</body>
</html>