<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<link href="style.css" rel="stylesheet" type="text/css">

<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
function openDaumPostcode(){
	new daum.Postcode({
		oncomplete:function(data){
			document.getElementById('zipcode').value=data.postcode1+"-"+data.postcode2;
			document.getElementById('addr').value=data.address;
		}
	
	}).open();
}
</script>
<script type="text/javascript">
function check(){
	if(document.editForm.passwd.value='')
		{
		alert("기존 암호를 입력하세요")
		return false
		}
	if(document.editForm.npwd.value='')
		{
		alert("새로운 암호를 입력하세요")
		return false
		}
	if(document.editForm.npwd2.value='')
		{
		alert("암호확인을 입력하세요")
		return false
		}
	if(document.editForm.npwd.value!=document.editForm.npwd2.value){
		alert("새로운 암호와 암호확인이 일치하지 않습니다.")
		return false
	}
	document.editForm.submit()
}
</script>
<style type="text/css">
	body{
	background-color: #ccdd99;
	}
	
	table{
	margin:auto;
	line-height:36px;
	border:1px;
	width:80%;
	background-color:orange;
	}
</style>
<body>
	<h2 align="center">회원정보 수정 폼</h2>
	<form method="post" name="editForm" action="editPro.do">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" id="id" name="id" value="${memberDto.id}" readonly="readonly">
				</td>
			</tr>
			
			<tr>
				<td>이전암호</td>
				<td><input type="password" id="passwd" name="passwd">
				</td>
			</tr>
			
			<tr>
				<td>암호</td>
				<td><input type="password" id="npwd" name="npwd">
				</td>
			</tr>
			
			<tr>
				<td>암호확인</td>
				<td><input type="password" id="npwd2" name="npwd2"></td>
			</tr>
			
			<tr>
				<td>이름</td>
				<td><input type="text" id="name" name="name" size="10" value="${memberDto.name}">
				</td>
			</tr>
			
			<tr>
				<td>주민번호</td>
				<td>
					<input type="text" id="jumin1" name="jumin1" size="6" maxlength="6">
					<input type="text" id="jumin2" name="jumin2" size="7" maxlength="7">
				</td>
			</tr>
			
			<tr>
				<td>Email</td>
				<td><input type="text" id="email" name="email" size="30" value="${memberDto.email}">
				</td>
			</tr>
			
			<tr>
				<td>우편번호</td>
				<td><input type="text" id="zipcode" name="zipcode" size="7" value="${memberDto.zipcode}">
				<td><input type="button" value="우편번호찾기" onclick="openDaumPostcode()">
				</td>
			</tr>
			
			<tr>
				<td>주소</td>
				<td><input type="text" id="addr" name="addr" size="50">
				</td>
			</tr>
			
			<tr>
				<td>상세주소</td>
				<td><input type="text" id="details" name="details" size="20">
				</td>
			</tr>
			
			<tr>
				<td>job</td>
				<td>
					<select name="job">
						<option value="${modelDto.job}">${memberDto.job}</option>
						<option value="회사원">회사원</option>
						<option value="연구전문직">연구전문직</option>
						<option value="교수학생">교수학생</option>
						<option value="공무원">공무원</option>
						<option value="기타">기타</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<!-- 
					<input type="submit" value="회원정보수정">
					 -->
					<input type="button" value="회원정보수정" onclick="check()">
					<input type="reset" value="취소" onclick="location='main.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>