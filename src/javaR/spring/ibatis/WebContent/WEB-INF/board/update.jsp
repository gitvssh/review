<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//String num=request.getParameter("num");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update.jsp</title>
</head>
<body>

<form method="post" action="update.do"><br>
	 <input type="hidden" name="num" value="${board.num}">
	 
	 <table border=10 align=center width=407 
	 bgColor="margenta" cellpadding="1" cellspacing="0"> 
	 
	 <tr height="40px">
	  <td>글쓴이</td>
	  <td><input type="text" id="writer" name="writer" 
	  value="${board.writer}" maxlength="20"/> </td>
   </tr>
      
   <tr>
     <td>제목</td>
     <td>
       <input type="text" id="subject" name="subject" 
       value="${board.subject}" size=40 maxlength="40">
     </td>
   </tr>
   
   <tr>
     <td>이메일</td>
     <td>
       <input type="text" id="email" name="email"
        value="${board.email}" size=30 maxlength="30">
     </td>
   </tr>
	 
	 <tr>
     <td>글내용</td>
     <td> 
       <textArea id="content" name="content" rows="13" 
       cols="40">${board.content }</textArea>
    </td>
   </tr>
      
	  <tr>
      <td>비빌번호</td>
      <td>
        <input type="password" id="pwd" name="pwd" 
        size=20 maxlength="20">
     </td>
    </tr>  
    
     <tr>
      <td colspan=2 align="center">
        <input type="submit" value="수정">
        <input type="button" value="취소" OnClick=history.back()>
      </td>
     </tr>
	 </table>
	  
</form>

</body>
</html>