<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.*" %>

<%--cookie_view.jsp --%>
<%
//request.setCharacterEncoding("utf-8");
%>
<html>
<body>
<%
Cookie cookies[]=request.getCookies();//모든 쿠키를 얻는다 
String visitor=null;//변수

if(cookies!=null){//쿠키가 있으면
	for(int i=0;i<cookies.length;i++){
		if(cookies[i].getName().equals("visitor")){
			
			
			visitor=URLDecoder.decode(cookies[i].getValue());//쿠키값을 얻는다 
			
			//out.println("쿠키이름:"+cookies[i].getName());
			//out.println("쿠키 값:"+cookies[i].getValue());
		}//if
	}//for
}//if
%>
<%
if(visitor==null){//처음 방문이면
	%>
	 <form method="post" action="cookie_make.jsp">
		    이름을 입력 하시요 <br>
	     <input type="text" name="visitor">
	     <input type="submit" value="전송">
	 </form>
	
	<%
}else{//처음 방문이 아닐때
	out.println("<h3>"+visitor+"님 반갑습니다</h3>");
}//else 
%>
</body>
</html>