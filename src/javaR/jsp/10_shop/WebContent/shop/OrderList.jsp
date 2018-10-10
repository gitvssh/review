<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="shopdb.*"%>

<%--OrderList.jsp--%>

<%--dao 객체생성--%>

<jsp:useBean id="orderMgr" class="shopdb.OrderMgr"/>

<%
shopdb.ProductMgr proMgr=ProductMgr.getDao();//dao 객체얻기
%>

<%@ include file="Top.jsp"%>

<%
if(session.getAttribute("mem_id")==null){
	response.sendRedirect("Login.jsp");
}else{
	mem_id=(String)session.getAttribute("mem_id");
}
%>
<html>
<head>
<title>Insert title here</title>

<link href="style.css" rel="stylesheet" type="text/css">
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="script.js"></script>

</head>
<body bgcolor="#996600" topmargin="20">
	<table width="80%" align="center" bgcolor="#FFFF99">
		<tr>
			<td align="center" colspan="5">
			<br>
			<h3><%=mem_id %>님의 구매목록</h3>
			</td>
		</tr>
		
		<tr>
			<td align="center" bgcolor="#FFFFCC">
				<table width="95%" align="center" bgcolor="#FFFF99">
					<tr bgcolor="#996600">
						<td align="center">주문번호</td>
						<td align="center">제품</td>
						<td align="center">주문수량</td>
						<td align="center">주문날짜</td>
						<td align="center">주문상태</td>
					</tr>
					
					<%
					Vector vec=orderMgr.getOrder(mem_id);
					
					if(vec.size()==0){//구매목록이 업승면
					%>
						<tr>
							<td align="center" colspan="5">주문하신 물품이 없습니다.</td>
						</tr>
					<%
					}else{//구매목록이 있으면
						for(int i=0;i<vec.size();i++){
							OrderDto orddto=(OrderDto)vec.get(i);
							
							String code=request.getParameter("code");
							int pro_no=orddto.getPro_no();
							ProductDto proDto=proMgr.getProduct(code,pro_no);//proMgr 메서드 호출하여 해당 정보들 가져옴
							%>
							<tr>
								<%--주문번호 --%>
								<td align="center"><%=orddto.getOrdno() %></td>
								<!-- 상품명 클릭하면, 상세보기 -->
								<td align="center">
									<a href="javascript:productDetail('<%=proDto.getCode() %>')">
										<%=proDto.getName() %>
									</a>
								</td>
								
								<!-- 수량 -->
								<td align="center"><%=orddto.getQuantity() %></td>
								<!-- 주문날짜 -->
								<td align="center"><%=orddto.getOrddate() %></td>
								<!-- 상태 -->
								<td align="center">
									<%
									switch(Integer.parseInt(orddto.getState())){
									case 1:out.println("접수중");break;
									case 2:out.println("접수");break;
									case 3:out.println("입금확인");break;
									case 4:out.println("배송준비");break;
									case 5:out.println("배송중");break;
									default:out.println("배송확인");break;
									}
									%>
								</td>
							</tr>
							<%
						}//for
					}//if-else
					%>
				</table>
			</td>
		</tr>
	</table>
	
	<%@ include file="Bottom.jsp" %>
	
	<form name="detail" method="post" action="ProductDetail.jsp">
		<input type="hidden" name="code">
	</form>
</body>
</html>