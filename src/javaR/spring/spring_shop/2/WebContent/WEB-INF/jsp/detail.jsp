<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center" class="body">
		<h2>상품 상세 화면</h2>
		<table>
			<tr>
				<td>
					<img src="img/${item.picture_url}" width="200" height="200">
				</td>
				
				<td>
					<table>
						<tr height="50">
							<td width="80">상품명</td>
							<td width="160">${item.item_name}</td>
						</tr>
						
						<tr height="50">
							<td width="80">가격</td>
							<td width="160">${item.price}</td>
						</tr>
						
						<tr height="50">
							<td width="80">비고</td>
							<td width="160">${item.description}</td>
						</tr>
						
						<tr>
							<td colspan="2" align="center" width="240">
								<a href="index.html">목록으로 돌아가기</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>