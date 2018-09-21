<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="java.sql.*"
    %>

<%!
String DRIVER="com.mysql.jdbc.Driver";
String URL="jdbc:mysql://localhost:3306/mydb";
String USER="root";
String PWD="12345";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List.jsp</title>
<style type="text/css">
	body{background-color:linen;}
	tr{line-height:30px;}
	textArea{resize:none;}
</style>

</head>
<body>
	<center><h2>게시판 리스트</h2></center>
	
	<table width="430" align=center border="1" cellpadding="1" cellspacing="0">
		<tr>
			<td align="right">
				<a href="Writer.jsp">글쓰기
					<img src="../imgs/a55.jpg" alt="새글" border="0">
				</a>
			</td>
		</tr>
	</table>
<%
Class.forName(DRIVER);
Connection con=DriverManager.getConnection(URL,USER,PWD);
Statement stmt=con.createStatement();

String sql="Select num,subject,email,writer,wdate,readcount From myboard order by num desc";

ResultSet rs=stmt.executeQuery(sql);
%>
<table border=1 width=430 align=center bgcolor="#ccc">
	<tr bgColor="cyan" height="20">
		<td width="50">번호</td>
		<td width="130">글제목</td>
		<td width="75">작성자</td>
		<td width="103">작성일</td>
		<td width="103">조회수</td>
	</tr>
	<%
	while(rs.next()){
		int num=rs.getInt("num");
		String subject=rs.getString("subject");
		String email=rs.getString("email");
		String writer=rs.getString("writer");
		String wdate=rs.getString("wdate");
		int readcount=rs.getInt("readcount");
	%>
	<tr>
	<td><%=num %></td>
	
	<%-- <td><%=subject %></td>--%>
	<%-- 글제목 클릭하면 내용보기 --%>
	<td>
		<a href="Content.jsp?num=<%=num %>">
			<%=subject %>
		</a>
	</td>
	<td>
	<a href=mailto:<%=email %>>
		<%=writer %>
	</a>
	</td>
	
	<td><%=wdate%></td>
	<td><%=readcount%></td>
	
	<%
	}
	rs.close();
	stmt.close();
	con.close();
	%>
</table>
</body>
</html>