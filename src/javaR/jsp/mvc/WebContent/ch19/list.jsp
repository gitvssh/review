<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/view/color.jspf" %>

<fmt:requestEncoding value="utf-8"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list.jsp</title>

</head>
<body bgcolor="${bodyback_c }">
	<center><b>글목록(전체 글:${count})</b></center>
	
	<table width="700" align="center">
		<tr>
			<td align="right" bgcolor="${value_c }">
				<a href="${ctxpath }/ch19/writeForm.do">글쓰기</a>
			</td>
		</tr>
	</table>
	
	<c:if test="${count==0 }">
		<table width="700" border="1" align="center">
			<tr>
				<td align="center">
				게시판에 저장된 글이 없습니다.
				</td>
			</tr>
		</table>
	</c:if>
	
	<c:if test="${count>0 }">
		<table border="1" width="700" align="center">
			<tr height="30" bgcolor="${value_c }">
				<td align="center" width="50">번호</td>
				<td align="center" width="250">글제목</td>
				<td align="center" width="100">작성자</td>
				<td align="center" width="150">작성일</td>
				<td align="center" width="50">조 회</td>
				<td align="center" width="100">IP</td>
			</tr>
			
			<c:forEach var="dto" items="${articleList }">
				<tr>
					<td align="center">
					<c:out value="${number}"/>
					<c:out value="${number-1}"/>
					</td>
					
					<td>
					<c:if test="${dto.re_level>0}">
						<img src="imgs/level.gif" width="${5*dto.re_level}" height="16"/>
						<img src="imgs/re.gif">
					</c:if>
					
					<c:if test="${dto.re_level==0}">
						<img src="imgs/level.gif" width="${5*dto.re_level}" height="16"/>
					</c:if>
						
					<a href="${ctxpath}/ch19/content.do?num=${dto.num}&pageNum=${currentPage}">
						${dto.subject}
					</a>
					
						<c:if test="${dto.readcount>=20}">
							<img src="imgs/hot.gif" border="0" height="16"/>
						</c:if>
					</td>
					
					<td>
						<a href="mailto:${dto.email}">${dto.writer}</a>
					</td>
					
					<td>
						${dto.regdate}
					</td>
					
					<td>
						${dto.readcount}
					</td>
					
					<td>
						${dto.ip}
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>