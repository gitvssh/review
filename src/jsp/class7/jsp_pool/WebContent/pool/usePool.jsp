<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>

<%--usePool.jsp--%>

<html>
<body>
<h2> 커넥션 풀 사용</h2>
<table border="1" width="70%">
	<tr>
		<th width="100">글쓴이</th>
		<th width="150">Email</th>
		<th width="200">주소</th>
	</tr>
<%
Connection con=null;
Statement stmt=null;
ResultSet rs=null;

//현재환경의 naming Context 획득하기
Context ct=new InitialContext();
Context envCt=(Context)ct.lookup("java:comp/env");
//InitialContext()는 웹 어플리케이션이 처음으로 배치될때 설정되고
//모든 설정된 엔트리와 자원은 JNDI namespace의
//java:comp/env 부분에 놓이게 됩니다.

//그래서 자원 접근을
//Context ct=new InitialContext(); 이렇게 합니다.

//Context envCt=(Context)ct.lookup("java:comp/env");
//JNDI에 등록된 생성할 자원 이름
//(즉, 컨텍스트에 대한 상대적인 이름이다)

DataSource ds=(DataSource)envCt.lookup("jdbc/mysql");
//server.xml 또는 context.xml, web.xml에서
//설정해놓은 이름이다

con=ds.getConnection();//Connection 얻기

String sql="select * from test";
stmt=con.createStatement();
rs=stmt.executeQuery(sql);

while(rs.next()){
	String name=rs.getString("name");
	String email=rs.getString("email");
	String addr=rs.getString("addr");
	%>
	<tr>
		<td><%=name %></td>
		<td><%=email %></td>
		<td><%=addr %></td>
	</tr>
	<%
}//while
rs.close();
stmt.close();
con.close();
%>
</table>
</body>
</html>