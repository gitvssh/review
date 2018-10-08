<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="shopdb.*" %>

<%--ProductList.jsp --%>
<%
request.setCharacterEncoding("utf-8");
%>

<%!
List shopList;
%>

<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="script.js"></script>
</head>
<body bgcolor="#99600" topmargin="20">
	<%@ include file="Top.jsp" %>
	
<%
shopdb.ProductMgr dao=shopdb.ProductMgr.getDao();
shopList=dao.getGoodList();

if(shopList.isEmpty()){
%>
등록된 상품이 없습니다.
<%	
}else{
%>
	<table border="1" width="80%" cellpadding="3" align="center">
		<tr>
		<%
		for(int i=0;i<shopList.size();i++){
			if(i%3==0){
				out.println("</tr><tr>");
			}
			
			ProductDto dto=(ProductDto)shopList.get(i);
			%>
			<td>
			<table border="0">
			
				<tr align="center" bgcolor="#D0D0D0" height="120%">
					<td colspan="2"><%=dto.getName() %></td>
				</tr>
			
				<tr>
					<td colspan="2" align="center">
					현재경로 : <%=request.getContextPath() %>
					<%
					if(dto.getStock()>0){
						%>
						<a href="javascript:productDetail('<%=dto.getCode()%>')">
						<img src="<%=request.getContextPath() %>/imgs/<%=dto.getImage() %>" width="150" height="150">
						</a>
						<%
					}else{
						%>
						<script>
							alert("<%=dto.getName()%> 품절상품입니다")
						</script>
						<%
					}//if-else
					%>
					</td>
				</tr>
				
				<tr>
					<td width="50%">상품코드:</td><td><%=dto.getCode() %></td>
				</tr>
				
				<tr>
					<td>가격:</td><td><%=dto.getPrice() %></td>
				</tr>
				
				<tr>
					<td>출시날짜:</td><td><%=dto.getRegdate() %></td>
				</tr>
				
				<tr>
					<td>제조회사</td><td><%=dto.getComp() %></td>
				</tr>
				
				<tr>
					<td>물량,Stock</td>
					<td>
					<%if(dto.getStock()>0){ %>
						<%=dto.getStock() %>
					<%}else{ %>
					품절
					<%} %>
					</td>
				</tr>
			</table>
			</td>
			<%
		}//for shoplist
		%>
		</tr>
	</table>
<%	
}//if-else
%>	
	<form name="detail" method="post" action="ProductDetail.jsp">
		<input type="hidden" name="code">
	</form>
	
	<%@ include file="Bottom.jsp" %>
</body>
</html>
