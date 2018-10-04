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
<%
request.setCharacterEncoding("utf-8");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{background-color:linen;}
	tr{line-height:30px;}
	textArea{resize:none;}
</style>

</head>
<body>
	<h1>글내용 보기</h1>
	<%
	/*
	개별 자료를 구분하기 위해서 각 자료모다 기본키(pk) 인 num을
	가져와서 변수 num에 저장한다.
	*/
	String num=request.getParameter("num");//List.jsp에서 넘겨준 num
	int readcount=0;//조회수를 넣을 변수 선언
	
	Class.forName(DRIVER);
	Connection con=DriverManager.getConnection(URL,USER,PWD);
	
	String sql="select * from myboard where num="+num;//num에 해당하는 자료를 DB에서 가져온다.
	Statement stmt=con.createStatement();//Statement 생성
	ResultSet rs=stmt.executeQuery(sql);//쿼리문 수행
	
	while(rs.next()){
		String writer=rs.getString("writer");
		String subject=rs.getString("subject");
		String email=rs.getString("email");
		String content=rs.getString("content");
		
		String pwd=rs.getString("pwd");
		String wdate=rs.getString("wdate");
		readcount=rs.getInt("readcount");
		String ip=rs.getString("ip");
		readcount++;
	%>
	<table width="407" border=1 bgcolor="#ccc">
	<tr>
	<td align="right">
		<a href="Writer.jsp">새글쓰기</a>&nbsp;
		<a href="Edit.jsp?num=<%=num%>">글수정</a>&nbsp;
		<a href="Delete.jsp?num=<%=num%>">글삭제</a>&nbsp;
		<a href="List.jsp?num=<%=num%>">리스트</a>&nbsp;
	</td>
	</table>
	
	<table width="407" border=1>
	<tr>
		<td>이름</td>
		<td>[<%=writer %>]</td>
	</tr>
	
	<tr>
		<td>글제목</td>
		<td>[<%=subject%>]</td>
	</tr>
	
	<tr>
		<td>날짜</td>
		<td>[<%=wdate%>]</td>
	</tr>
	
	<tr>
		<td>비밀번호</td>
		<%
		String temp=(String)session.getAttribute("id");
		temp="";
		if(temp.equals("admin")){
			out.println(pwd);
		}else{
			out.println("***");
		}
		%>
	</tr>
	
	<tr>
		<td>조회수</td>
		<td>[<%=readcount%>]</td>
	</tr>
	
	<tr>
		<td>IP</td>
		<td>[<%=ip%>]</td>
	</tr>
	
	<tr>
		<td colspan="2" width="407">
		<br>
		<%=content %>
		<br><br>
		</td>
	</tr>
	</table>
	<%
	}
	rs.close();
	stmt.close();
	
	sql="update myboard set readcount=? where num=?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	
	pstmt.setInt(1,readcount);
	pstmt.setInt(2,Integer.parseInt(num));
	pstmt.executeUpdate();
	
	pstmt.close();
	con.close();
	%>

</body>
</html>