<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>(로그인 입력화면 )login.jsp</title>
</head>

<body>
  <div align="center" class="body">
   <h2>로그인 입력화면</h2>
   
   <!-- user 모델빈 이름, 컨트롤러의 toUpForm()메서드에 대응된다  -->
   <form:form modelAttribute="user" method="post" action="login.html">
   	<spring:hasBindErrors name="user">
   	  <font color="red">
   	    <c:forEach var="error" items="${errors.globalErrors}">
   	       <spring:message code="${error.code}"/>
   	    </c:forEach>
   	  </font>
   	</spring:hasBindErrors>
   
   <table>
   
   <tr height="40px">
     <td>user ID</td> 
     <td>
     <!-- path="userId"는 User모델의 변수(프로퍼티)이다 -->
      <form:input path="userId" cssClass="userId"/>
      <font color="red"><!-- 에러메시지 출력 -->
         <form:errors path="userId"></form:errors>
      </font>
     </td>
   </tr> 
   
   <tr height="40px">
     <td>패스워드</td> 
     <td>
     <!--  User모델의 변수(프로퍼티)이다 -->
      <form:input path="password" cssClass="password"/>
      <font color="red"><!-- 에러메시지 출력 -->
         <form:errors path="password"></form:errors>
      </font>
     </td>
   </tr> 
   
   <tr>
    <td align="center" colspan="2">
    	<input type="submit" value="로그인">
    	<input type="reset" value="리셋">
    </td>
   </tr>
   </table>
   
   </form:form>
  </div>
 </body>
 </html>
 