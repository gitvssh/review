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
request.setCharacterEncoding("utf-8");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WriteSave.jsp</title>
</head>
<body>
<%
String ip=request.getRemoteAddr();//클라이언트의 ip를 구한다.

if(ip.equals("192.168.0.22")){
	out.println("<script>");
	out.println("alert('접근금지 : '"+ip+")");
	out.println("history.back();");
	out.println("</script>");
}
%>

<%
try{
	Class.forName(DRIVER);
	
	String writer=request.getParameter("writer");
	String subject=request.getParameter("subject");
	String email=request.getParameter("email");
	String content=request.getParameter("content");
	String pwd=request.getParameter("pwd");
	
	Connection con=DriverManager.getConnection(URL,USER,PWD);
	
	
	String sql="insert into Myboard (writer,subject,email,content,pwd,wdate,ip) values(?,?,?,?,?,NOW(),?)";
	//NOW():년월일시분초, curdate:년월일=>mysql 날짜 입력
	
	//Sstatement는 실행시 인자가 들어간다.
	//PreparedStatement 는 생성시 인자가 들어간다.
	PreparedStatement pstmt=con.prepareStatement(sql);
	
	pstmt.setString(1,writer);
	pstmt.setString(2,subject);
	pstmt.setString(3,email);
	pstmt.setString(4,content);
	pstmt.setString(5,pwd);
	//날짜
	pstmt.setString(6,ip);
	
	//쿼리수행
	pstmt.executeUpdate();//DB에 저장ㅇ하는 쿼리문 수행
	//pstmt.executeUpdate(); insert, update, delete
	//pstmt.executeQuery(); select
	
	pstmt.close();
	con.close();
	
	response.sendRedirect("List.jsp");
}catch(Exception e){
	System.out.println("SQL예외 : "+e);
	
	out.println("<script>");
	out.println("alert('SQL Error :'"+e+")");
	out.println("history.back();");
	out.println("</script>");
	
}
%>
</body>
</html>