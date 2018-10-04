<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="boardre.*"%>
<%-- Delete.jsp--%>
<%
request.setCharacterEncoding("utf-8");
int num=Integer.parseInt(request.getParameter("num"));//글내용보기에서 넘어온 데이터
int nowPage=Integer.parseInt(request.getParameter("page"));

String inPass;//입력 암호
String dbPass;//DB에서 가지고 온 암호
boardre.BoardDao dao=new boardre.BoardDao();//객체생성

if(request.getParameter("pass")!=null){//암호를 입력했으면
	BoardDto dto=dao.getBoard(num);

	inPass=request.getParameter("pass");
	dbPass=dto.getPass();
	
	if(inPass.equals(dbPass)){
		dao.deleteBoard(num);
		response.sendRedirect("List.jsp?page="+nowPage);
	}else{
		%>
		<script>
		alert("암호가 틀립니다")
		history.back()
		</script>
<%
	}
}
%>
<html>
<head>
	<script type="text/javascript">
	function check(){
		if(document.delForm.pass.value==''){
			alert("암호를 입력하세요")
			delForm.pass.focus()
			return false
		}
		document.delForm.submit();
	}
	</script>
</head>
<body>
	<table width="70%" cellspacing="0" cellpadding="3">
	<tr>
		<td bgcolor="#dddddd" height=21 align=center style="font-family:궁서체;font-size:14pt;color:red">
		비밀번호를 입력해 주세요
		</td>
	</tr>
	</table>
	
	<form name="delForm" method="post" action="Delete.jsp">
	<table width="70%" cellspacing=0 cellpadding=2>
		<tr>
			<td align=center>
				<table align=center border=0 width="100%">
				
					<tr>
						<td align=center>
							<input type="password" name="pass" size=15>
						</td>
					</tr>
					
				
					<tr>
						<td>
							<hr color="#eeeeee">
						</td>
					</tr>
					
				
					<tr>
						<td align=center>
							<input type="button" value="삭제완료" onclick="check();">
							<input type="reset" value="다시쓰기">
							<input type="button" value="뒤로" onclick="history.go(-1)">
							
							<input type="hidden" name="page" value="<%=nowPage%>">
							<input type="hidden" name="num" value="<%=num%>">
						</td>
					</tr>
					
				</table>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>