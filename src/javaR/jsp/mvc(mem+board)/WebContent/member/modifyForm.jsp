<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/view/color.jspf"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>modifyForm.jsp</title>
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
function checkIt(){
	var inputForm=eval("document.userInput");
	
	if(!inputForm.passwd.value){
		alert("비밀번호를 입력하세요")
		inputForm.passwd.focus()
		return false
	}
	
	if(inputForm.passwd.value!=inputForm.passwd2.value){
		alert("암호가 일치하지 않습니다")
		inputForm.passwd.value=""
		inputForm.passwd2.value=""
		inputForm.passwd.focus()
		return false
	}
	
	if(!inputForm.username.value){
		alert("사용자 이름을 입력하세요")
		inputForm.username.focus()
		return false;
	}
	
	if(!inputForm.jumin1.value || !inputForm.jumin2.value){
		alert("주민등록번호를 입력하세요")
		inputForm.jumin1.focus()
		return false
	}
}
</script>
</head>
<body bgcolor="${bodyback_c}">
	<form method="post" action="${ctxpath}/member/modifyPro.do"
		name="userInput" onSubmit="return checkIt()">
		<table width="600" border="1" cellspacing="0" cellpadding="3">
			<tr>
				<td colspan="2" height="39" bgcolor="${title_c}" align="center">
					<font size="+1"><b>회원 정보수정</b></font>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">회원의 정보를 수정합니다.
				</td>
			</tr>
			
			<tr>
				<td width="200" bgcolor="${value_c}"><b>아이디 입력</b></td>
				<td width="400" bgcolor="${value_c}">&nbsp;</td>
			</tr>
			
			<tr>
				<td width="200">사용자 ID</td>
				<td width="400">${dto.id}
				<input type="hidden" name="id" value="${sessionScope.memId}">
				</td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="passwd" size="10" maxlength="10">
				</td>
			</tr>
			
			<tr>
				<td bgcolor="${value_c}"><b>개인정보 입력</b></td>
				<td bgcolor="${value_c}">&nbsp;</td>
			</tr>
			
			<tr>
				<td>사용자 이름</td>
				<td>
					<input type="text" name="name" size="15" maxlength="20" value="${dto.name}">
				</td>
			</tr>
			
			<tr>
				<td>주민등록번호</td>
				<td>
					<input type="text" name="jumin1" size="6" maxlength="6" value="${dto.jumin1}">
					<input type="text" name="jumin2" size="7" maxlength="7" value="${dto.jumin2}">
				</td>
			</tr>
			
			<tr>
				<td>Email</td>
				<td>
					<c:if test="${empty dto.email}">
						<input type="text" name="email" size="40" maxlength="30">
					</c:if>
					
					<c:if test="${!empty dto.email}">
						<input type="text" name="email" size="40" maxlength="30" value="${dto.email}">
					</c:if>
				</td>
			</tr>
			
				<tr>
				<td>우편번호</td>
				<td>
				<input type="text" name="zipcode" id="zipcode" size="7" maxlength="7" value="${dto.zipcode}">
				<input type="button" value="우편번호찾기" onclick="openDaumPostcode()">
				</td>
			</tr>
			
			<%-- 주소 --%>
			<tr>
				<td>주소</td>
				<td>
				<input type="text" name="addr" id="addr" size="50" value="${dto.addr}">
				</td>
			</tr>
			
			<tr>
				<td>직업</td>
				<td>
				<select name="job" id="job">
					<option value="${dto.job}">${dto.job}</option>
					<option value="회사원">회사원</option>
					<option value="공무원">공무원</option>
					<option value="전문연구직">전문연구직</option>
					<option value="교수학생">교수학생</option>
					<option value="기타">기타</option>
				</select>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center" bgcolor="${value_c}">
					<input type="submit" value="수정">
					<input type="button" value="취소" onclick="document.location.href='${ctxpath}/member/main.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>