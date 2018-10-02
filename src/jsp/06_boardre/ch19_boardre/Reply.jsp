<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="boardre.*"
    %>
    
<%--Reply.jsp --%>
<%
request.setCharacterEncoding("utf-8");
boardre.BoardDao dao=new boardre.BoardDao();
%>

<%
int nowPage=Integer.parseInt(request.getParameter("page"));//글내용
int num=Integer.parseInt(request.getParameter("num"));

BoardDto dto=dao.getBoard(num);//Dao 메서드호출
String subject=dto.getSubject();//글제목
String content=dto.getContent();//글내용
%>
<html>
<body>
	<table width="460" cellspacing=0 cellpadding=3 align=center>
		<tr>
			<td bgcolor="#cccc00" height=21 align=center>
			답변글 쓰기
			</td>
		</tr>
	</table>
	
	<form name="reForm" method="post" action="ReplyProc.jsp">
	
		<table width="527" cellspacing=0 cellpadding=7 align=center>
			<tr>
				<td align=center>
					<table border=0>
						<tr>
							<td width="20%">이름</td>
							<td width="80%">
								<input type="text" name="name" size="20">
							</td>
						</tr>
						
						<tr>
							<td>Email</td>
							<td>
							<input type="text" name="email" size="40">
							</td>
						</tr>
						
						<tr>
							<td>Homepage</td>
							<td>
							<input type="text" name="homepage" size="40" value="http://">
							</td>
						</tr>
						
						<tr>
							<td>제목</td>
							<td>
								<input type="text" name="subject" size="50" value="답글:<%=subject %>">
							</td>
						</tr>
						
						<tr>
							<td>글내용</td>
							<td>
							<textarea name="content" rows="10" cols="50"><%=content+"\n" %>---답글쓰세요---<%="\n"%></textarea>
							</td>
						</tr>
						
						<tr>
							<td>암호</td>
							<td>
								<input type="password" name="pass" size="15">
							</td>
						</tr>
						
						<tr>
							<td colspan="2" height=5><hr size=2 color=red>
							</td>
						</tr>
						
						<tr>
							<td colspan=2 align=center>
								<input type="submit" value="답글등록">
								<input type="reset" value="다시쓰기">
								<input type="button" value="뒤로" onclick="history.go(-1)">
								
								<input type="hidden" name="ip" value="<%=request.getRemoteAddr()%>">
								<input type="hidden" name="page" value="<%=nowPage %>">
								<input type="hidden" name="num" value="<%=num %>">
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	
	</form>
</body>
</html>