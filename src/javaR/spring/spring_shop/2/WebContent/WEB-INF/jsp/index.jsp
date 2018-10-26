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
		<h2>상품 목록 화면</h2>
		<table border="1">
			<tr class="header">
				<th align="center" width="80">상품ID</th>
				<th align="center" width="320">상품명</th>
				<th align="center" width="100">가격</th>
			</tr>
			
			<c:forEach var="item" items="${itemList }">
				<tr class="record">
					<td align="center">${item.item_id }</td>
					<td align="left">
						<a href="detail.html?item_id=${item.item_id}">
							${item.item_name}
						</a>
					</td>
					<td align="center">${item.price}원</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>