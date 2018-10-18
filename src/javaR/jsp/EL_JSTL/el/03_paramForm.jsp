<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--03_testForm.jsp--%>
<%
session.setAttribute("id","admin");
%>
<html>
<body>
	<form method="post" action="03_param.jsp">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="홍길동"></td>
			</tr>
			
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" value="서울 서대문구"></td>
			</tr>
			
			<tr>
				<td>전화</td>
				<td><input type="text" name="tel" value="010-2323-1235"></td>
			</tr>
			
			<tr>
				<td>
				<input type="checkbox" name="hobby" value="트래킹">트래킹<br>
				<input type="checkbox" name="hobby" value="여행">여행<br>
				<input type="checkbox" name="hobby" value="축구">축구<br>
				<input type="checkbox" name="hobby" value="야구">야구<br>
				<input type="checkbox" name="hobby" value="공부">공부<br>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="서버로전송">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>