<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/view/color.jspf" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>inputForm.jsp</title>

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
	if($('#id').val()==''){
		alert("id를 입력하세요")
		$('#id').focus()
		return false
	}
	
	 if($('#passwd').val()==''){
		alert("passwd를 입력하세요")
		$('#passwd').focus()
		$('#passwd').focus()
		return false
	}
	
	if($('#passwd2').val()==''){
		alert("passwd2를 입력하세요")
		$('#passwd2').focus();
		return false
	}
	
	if($('#passwd').val()!=$('#passwd2').val()){
		alert("passwd,passwd2가 일치하지 않습니다")
		$('#passwd').focus()
		return false
	}
	
	if($('#name').val()==''){
		alert("name을 입력하세요")
		$('#name').focus()
		return false
	} 
}//check()

function confirmIDCheck(){
	if($('#id').val()==''){
		
		alert("id를 입력하세요")
		$('#id').focus()
	}else{
		$.ajax({
			type:"POST",
			url:"confirmId.jsp",
			data:"id="+$('#id').val(),
			dataType:'JSON',
			success:function(data){
				if(data.check==1){
					alert("사용중인 id")
					$('#id').val("").focus()
				}else{
					alert("사용 가능한 id입니다.")
					$('#passwd').focus()
					
				}
			}
		})//$.ajax
	}
}//confirmIDCheck()
</script>
</head>
<body bgcolor="${bodyback_c}">
	<form method="post" name="userForm" action="${ctxpath}/member/inputPro.do" onSubmit="return check()">
		<table width="650" border="1" cellpadding="3">
			<tr>
				<td colspan="2" height="30" align="center" bgcolor="${value_c}">
					<b>회원가입</b>
				</td>
			</tr>
			
			<tr>
				<td with="120" bgcolor="${value_c}">
					<b>아이디</b>
				</td>
				<td bgcolor="${value_c}"></td>
			</tr>
			
			<tr>
				<td>사용자ID</td>
				<td>
					<input type="text" name="id" id="id" size="10">
					<input type="button" value="ID중복체크" onClick="confirmIDCheck()">
				</td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="passwd" id="passwd" size="15">
				</td>
			</tr>
			
			<tr>
				<td>비밀번호 확인</td>
				<td>
					<input type="password" name="passwd2" id="passwd2" size="15">
				</td>
			</tr>
			
			<tr>
				<td bgcolor="${value_c}"><b>개인정보 입력</b></td>
				<td bgcolor="${value_c}">&nbsp;</td>
			</tr>
			
			<tr>
				<td>사용자이름</td>
				<td>
					<input type="text" name="name" id="name" size="10">
				</td>
			</tr>
			
			<tr>
				<td>주민등록번호</td>
				
				<td>
					<input type="text" name="jumin1" id="jumin1" size="6" onkeyup="if(this.value.length==6) userForm.jumin2.focus();">
					-
					<input type="text" name="jumin2" id="jumin2" size="7" onkeyup="if(this.value.length==7) userForm.email.focus();">
				</td>
			</tr>
			
			<tr>
				<td>Email</td>
				<td>
					<input type="text" name="email" id="email" size="40">
				</td>
			</tr>
			
			<tr>
				<td>우편번호</td>
				<td>
				<input type="text" name="zipcode" id="zipcode" size=7>
				<input type="button" value="우편번호찾기" onclick="openDaumPostcode()">
				</td>
			</tr>
			
			<tr>
				<td>주소</td>
				<td>
					<input type="text" name="addr" id="addr" size=50>
				</td>
			</tr>
			
			<tr>
				<td>직업</td>
				<td>
					<select name="job" id="job">
						<option value="0">선택하세요</option>
						<option value="회사원">회사원</option>
						<option value="연구전문직">연구전문직</option>
						<option value="교수학생">교수학생</option>
						<option value="공무원">공무원</option>
						<option value="법조인">법조인</option>
						<option value="농축산">농축산</option>
						<option value="무직">무직</option>
						<option value="기타">기타</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center" bgcolor="${value_c}">
				<input type="submit" value="회원가입">
				<input type="reset" value="다시입력">
				
				<input type="button" value="가입안함" onClick="location='${ctxpath}/member/main.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>