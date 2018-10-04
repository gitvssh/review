<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="member.*"%>
<%@ include file="/view/color.jsp"%>

<%-- modifyForm.jsp --%>

<%
request.setCharacterEncoding("utf-8");//post 요청 한글처리
String id=(String)session.getAttribute("memId");
MemberDAO dao=MemberDAO.getInstance();
MemberDTO dto=dao.getMember(id);
%>

<html>
<head>
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
	 /* if(document.userForm.passwd.value==''){
		 alert("암호를 입력하세요");
		 document.userForm.passwd.focus();
		 return false;
	 }
	 if(document.userForm.passwd2.value==''){
		 alert("암호확인을 입력하세요");
		 document.userForm.passwd2.focus();
		 return false;
	 }
	 if(document.userForm.passwd.value!=document.userForm.passwd2.value){
		 alert("암호가 일치하지 않습니다.");
		 document.userForm.passwd.focus();
		 return false;
	 } */
	 if($('passwd').val()==''){
		 alert("암호를 입력하세요");
		 document.userForm.passwd.focus();
		 return false;
	 }
	 if($('passwdd2').val()==''){
		 alert("암호확인을 입력하세요");
		 document.userForm.passwd2.focus();
		 return false;
	 }
	 if($('passwd').val()!=$('passwd').val()){
		 alert("암호가 일치하지 않습니다.");
		 document.userForm.passwd.focus();
		 return false;
	 }
	 return true;
}
</script>
</head>
<body bgcolor="<%=bodyback_c%>">
<form name="userForm" action="modifyPro.jsp" onSubmit="return checkIt()">

<table width="600" border="1" cellpadding="3" align="center">
	<tr>
		<td colspan="2" height="30" bgcolor="<%=title_c %>" align="center">
		<b><font size="5">(^.^)회원정보 수정</font></b>
		</td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
		회원정보 수정합니다.
		</td>
	</tr>
	
	<tr>
		<td width="200" bgcolor="<%=value_c %>"><b>패스워드 입력</b></td>
		<td width="400" bgcolor="<%=value_c %>">
		&nbsp;
		</td>
	</tr>
	
	<tr>
		<td>사용자 ID</td>
		<td><%=dto.getId() %></td>
	</tr>
	
	<tr>
		<td>암호</td>
		<td><input type="password" name="passwd" id="passwd" size="20">필수입력</td>
	</tr>
	
	<tr>
		<td>암호확인</td>
		<td><input type="password" name="passwd2" id="passwd2" size="20">필수입력</td>
	</tr>
	
	<tr>
		<td width="200" bgcolor="<%=value_c %>">개인정보 입력</td>
		<td width="400" bgcolor="<%=value_c %>">&nbsp;</td>
	</tr>
	
	<tr>
		<td>사용자 이름</td>
		<td><input type="text" name="name" id="name" size="15" value="<%=dto.getName() %>">
		</td>
	</tr>
	
	<tr>
		<td>주민번호</td>
		<td>
		<%=dto.getJumin1() %>-<%=dto.getJumin2() %>
		</td>
	</tr>
	
	<%-- email --%>
	<tr>
		<td>Email</td>
		<td>
		<%
		String im=dto.getEmail();
		if(im==null){
			im="";
		}
		%>
		<input type="text" name="email" size="40" value="<%=im %>">
		</td>
	</tr>
	
	<%-- 우편번호 --%>
	<tr>
		<td>우편번호</td>
		<td>
		<%
		im=dto.getZipcode();
		if(im==null){
			im="";
		}
		%>
		<input type="text" name="zipcode" id="zipcode" size="7" maxlength="7" value="<%=im %>">
		<input type="button" value="우편번호찾기" onclick="openDaumPostcode()">
		</td>
	</tr>
	
	<%-- 주소 --%>
	<tr>
		<td>주소</td>
		<td>
		<%
		im=dto.getAddr();
		if(im==null){
			im="";
		}
		%>
		<input type="text" name="addr" id="addr" size="50" value="<%=im %>">
		</td>
	</tr>
	
	<tr>
		<td>직업</td>
		<td>
		<%
		im=dto.getJob();
		if(im==null){im="";}
		%>
		<select name="job">
		<%
		if(im==""){
			out.println("<option value='0'>선택하세요</option>");
		}else{
			out.println("<option value="+im+">"+im+"</option>");
		}
		%>
		<option value="회사원">회사원</option>
		<option value="공무원">공무원</option>
		<option value="전문연구직">전문연구직</option>
		<option value="교수학생">교수학생</option>
		<option value="기타">기타</option>
		</select>
		</td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="수정">
			<input type="button" value="취소" onclick="javaScript:location='main.jsp'">
		</td>
	</tr>
</table>

</form>
</body>
</html>