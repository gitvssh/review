<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
// int num=Integer.parseInt(request.getParameter("num"));
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>content.jsp 글내용 보기 </title>
</head>
<body bgcolor="#ccdd99">
  <center> <h2>글내용보기</h2></center>
  <%=request.getContextPath()%>
  
  
   <table  align="center" width=500 border="1" bgColor="margenta">
   
   	<tr height="40px">
			  <td width="150">글쓴이</td>
			  <td width="350">${board.writer} </td>
		</tr>
		
		<tr height="40px">
      <td>제 목 </td>
      <td>${board.subject} </td>
    </tr>
    
    <tr height="40px">
       <td>이메일 </td>
       <td>${board.email} </td>
    </tr>
     
    <tr height="40px">
       <td>날짜 </td>
       <td><fmt:formatDate value="${board.wdate}" type="date"/> </td>
    </tr>
    
    <tr height="40px">
       <td>조회수 </td>
       <td>${board.readcount} </td>
     </tr>
     
     <tr height="40px">
       <td>IP </td>
       <td>${board.ip} </td>
     </tr>
      
      <tr width="407" height="100">
       <td colspan="2" width=407>
          <pre>${board.content}</pre>
       </td>
     </tr>
       
   </table>
    
   
   <table width="500"  bgColor="margenta" 
   cellspacing="0" cellpadding="0">
      <tr>
        <td align="right">
          <a href="write.do">새글쓰기 </a>&nbsp;&nbsp;
          <a href="update.do?num=${board.num}">수 정</a>&nbsp;&nbsp;
          <a href="delete.do?num=${board.num}">삭 제</a>&nbsp;&nbsp;
          <a href="list.do?page=1">리스트</a> &nbsp;&nbsp;
        </td>
      </tr>
    </table>
    
</body>
</html>