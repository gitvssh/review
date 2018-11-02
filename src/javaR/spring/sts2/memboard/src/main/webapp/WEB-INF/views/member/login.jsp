<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
  
  body{background-color: #ccdd99;}
  
	table{
	margin:auto;
	line-height:40px; border:1px; width:80%; 
	background-color: orange;
	}
</style>


</head>
<body>
<h2><center>로그인</center></h2>
${msg}
 <form method="post" action="loginPro.do">
 	<table>
 	  <tr>
	      <td>ID</td>
	      <td><input type="text" id="id" name="id" size=20></td>
      </tr>
      
     <tr>
	     <td>암호</td>
	     <td><input type="password" id="passwd" name="passwd" size=20></td>
     </tr>
      
 	<tr>
	    <td colspan="2" align="center">
	      <input type="submit" value="로그인">
	      <input type="reset" value="취소">
	    </td>
    </tr>
 	  
 	</table>
 </form>

</body>
</html>