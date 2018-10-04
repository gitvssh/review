<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String []titles={
		  "서재응 완벽투구...게레로 3구 삼진",
		  "리틀 감독 서재을 12일부터 고전선발",
		  "박찬호 김선우 시범경기 등판 호투"
};

for(int i=0;i<titles.length;i++){
	 if(i==0){// 0번째 자료이면
		 %>
		 <strong> 
		 <%
		 }//if
			%>
			<%= titles[i] %><!--클라이언트로 응답 -->
		
		 <%
	  if(i==0){%>
	       </strong> 
		 <%
	  }//if
	  %>
			<br>
			<%
			}//for---
%>