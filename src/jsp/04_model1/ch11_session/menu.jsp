<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>구매CD를 고르세요</h2>
<form method="post"  action="cart.jsp">
	<select name="item">
		<option value="백아연CD" selected>백아연CD</option>
		<option value="안치환CD">안치환CD</option>
		<option value="허각CD">허각CD</option>
		<option value="임재범CD">임재범CD</option>
		<option value="아이유CD">아이유CD</option>
		<option value="윌리엄CD">윌리엄CD</option>
		<option value="로이킴CD">로이킴CD</option>
	</select>
	
	<input type="hidden" name="step" value="add">
	<input type="submit" value="선택">
</form>