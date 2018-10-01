<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="boardre.*"
    %>
<%-- Read.jsp --%>

<%
request.setCharacterEncoding("utf-8");
boardre.BoardDao dao=new boardre.BoardDao();
%>
<%
//List.jsp에서 보내준 값들 받기
int num=Integer.parseInt(request.getParameter("num"));
int nowPage=Integer.parseInt(request.getParameter("page"));
String keyField=request.getParameter("keyField");
String keyWord=request.getParameter("keyWord");

dao.upCount(num);//조회수 증가
BoardDto dto=dao.getBoard(num);

//모델빈 내용을 변수로 저장
String name=dto.getName();
String email=dto.getEmail();
String homepage=dto.getHomepage();

String subject=dto.getSubject();
String regdate=dto.getRegdate();
String content=dto.getContent();

String ip=dto.getIp();
int count=dto.getCount();
%>
<html>
<head>
	<script type="text/javascript">
	function list(){
		document.listForm.action="List.jsp";
		document.listForm.submit();
	}
	</script>
</head>
<body bgcolor="ivory">
<table align=center width="70%" border=1 cellpadding=3 cellspacing=0 borderColor="blue" bgcolor="ivory">
	<tr>
	<td bgColor="#9ca2ee" height=25 align=center>
		<font size=7>글내용 보기</font>
	</td>
	</tr>
	
	<tr>
	<td colspan="2">
		<table border=0 cellpadding=3 cellspacing=0 width="100%">
		<tr>
			<td align=center bgcolor="#dddddd" width="10%">이름</td>
			<td bgcolor="#ffffe8"><%=name %></td>
			
			<td align=center bgcolor="#dddddd" width="15%">등록날짜</td>
			<td bgcolor="#ffffe8"><%=regdate %> </td>
		</tr>
		
		<tr>
			<td align=center bgcolor="#dddddd" width="10%">메일</td>
			<td bgcolor="#fffffe8">
			<a href="mailtp:<%=email  %>"><%=email %></a>
			</td>
		
		<td align=center bgcolor="#dddddd" width="15%">홈페이지</td>
		<td bgcolor="#ffffe8">
			<a href="<%=homepage %>"><%=homepage %></a>
		</td>
		</tr>
		
		<tr>
			<td align=center bgcolor="#dddddd">제목</td>
			<td bgcolor="#ffffe8" colspan=3><%=subject %></td>
		</tr>
		
		<tr>
			<td bgcolor="#ccdde8" colspan=4><br>
			<%
				content=content.replace("\n","<br>");
			%>
			<%=content %>
		</tr>
		
		<tr>
			<td colspan=4 align=right>
				<%=ip %>로부터 글을 남기셨습니다./조회수:<%=count %>
			</td>
		</tr>
		</table>
	</td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
			[<a href="Post.jsp">새글쓰기</a>]&nbsp;
			[<a href="javascript:list()">리스트</a>]&nbsp;
			[<a href="Update.jsp?page=<%=nowPage%>&num=<%=num %>">수정</a>]&nbsp;
			[<a href="Reply.jsp?page=<%=nowPage %>&num=<%=num %>">답글쓰기</a>]&nbsp;
			[<a href="Delete.jsp?page=<%=nowPage %>&num=<%=num %>">삭제</a>]
		</td>
	</tr>
</table>
<%
if(keyWord==null||keyWord.equals("")){
%>
<form name="listForm" method="post">
	<input type="hidden" name="num" value="<%=num %>">
	<input type="hidden" name="page" value="<%=nowPage %>">
</form>
<%	
}else{
%>
<form name="listForm" method="post">
	<input type="hidden" name="num" value="<%=num %>">
	<input type="hidden" name="page" value="<%=nowPage %>">
	<input type="hidden" name="keyWord" value="<%=keyWord %>">
	<input type="hidden" name="keyField" value="<%=keyField %>">
</form>
<%	
}
%>
</body>
</html>