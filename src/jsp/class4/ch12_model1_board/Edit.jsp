<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.*"
    import="java.util.*"
    %>
<%!
String DRIVER="com.mysql.jdbc.Driver";
String URL="jdbc:mysql://localhost:3306/mydb";
String USER="root";
String PWD="12345";
%>

<%
request.setCharacterEncoding("UTF-8");
String num=request.getParameter("num");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit.jsp</title>
<style type="text/css">
	body{background-color:linen;}
	tr{line-height:30px;}
	textArea{resize:none;}
</style>
<script type="text/javascript">
function check(){
	if(document.editForm.pwd.value==''){
		alert("암호를 입력 하시요");
		document.editform.pwd.focus();
		return;
	}
	
	document.editForm.action="EditSave.jsp?num=<%=num%>";//****
	document.editForm.submit();
}
</script>
</head>
<body>
<%
Class.forName(DRIVER);
Connection con=DriverManager.getConnection(URL,USER,PWD);
Statement stmt=con.createStatement();

String sql="select * from myboard where num="+num;
ResultSet rs=stmt.executeQuery(sql);

while(rs.next()){
	String writer=rs.getString("writer");
	String subject=rs.getString("subject");
	String email=rs.getString("email");
	
	String content=rs.getString("content");
	String pwd=rs.getString("pwd");
	String wdate=rs.getString("wdate");

	int readcount=rs.getInt("readcount");
	String ip=rs.getString("ip");
	%>
	<h1>글 수정 폼</h1>
	<form name="editForm" method="post">
	<table border=1 width=407 bgcolor="margenta">
	<tr>
		<td>이름</td>
		<td>
		<input type="text" name="writer" value="<%=writer %>" size=10>
		</td>	
	</tr>
	
	<tr>
		<td>글제목</td>
		<td>
		<input type="text" name="subject" value="<%=subject %>" size=40>
		</td>
	</tr>
	
	<tr>
		<td>이메일</td>
		<td>
		<input type="text" name="email" value="<%=email%>" size=30>
		</td>
	</tr>
	
	<tr>
		<td>글내용</td>
		<td>
		<textarea name="content" rows="15" cols="40"><%=content%></textarea>
		</td>
	</tr>
	
	<tr>
		<td>암호</td>
		<td>
		<input type="password" name="pwd" size=10>
		</td>
	</tr>
	
	<tr>
		<td align="center" colspan="2">
			<input type="button" value="수정" onClick="javaScript:check()">
			&nbsp;
			<input type="button" value="이전으로 돌아가기" onClick="history.back()">
		</td>
	</tr>
	
	</table>
	
	</form>
	
	<%
}
%>



</body>
</html>