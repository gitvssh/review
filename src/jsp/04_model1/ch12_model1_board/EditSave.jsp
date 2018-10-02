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
request.setCharacterEncoding("UTF-8");
String num=request.getParameter("num");

Class.forName(DRIVER);
Connection con=DriverManager.getConnection(URL,USER,PWD);

String sql="select * from myboard where num="+num;
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(sql);

PreparedStatement pstmt=null;

if(!(rs.next())){
	out.println("해당 자료가 없습니다");
}else{
	String dbpwd=rs.getString("pwd");
	stmt.close();
	
	if(dbpwd.equals(request.getParameter("pwd"))){
		
		String writer=request.getParameter("writer");
		String subject=request.getParameter("subject");
		String email=request.getParameter("email");
		String content=request.getParameter("content");
		
		sql="update myboard set writer=?, subject=?, email=?, content=? where num="+num;
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1,writer);
		pstmt.setString(2,subject);
		pstmt.setString(3,email);
		pstmt.setString(4,content);
		
		pstmt.executeUpdate();
		
		response.sendRedirect("List.jsp?page=1");
		
		rs.close();
		pstmt.close();
		con.close();
	}else{
		%>
		<script>
			alert("비밀번호가 다릅니다.");
			history.go(-1);
		</script>
		
		<%
	}
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EditSave.jsp</title>
</head>
<body>

</body>
</html>