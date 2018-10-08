<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="shopdb.*" %>
<%@ page import="java.util.*" %>

<%-- CartList.jsp --%>

<jsp:useBean id="cartMgr" class="shopdb.CartMgr" scope="session"/>

<%
OrderDto ordDto=null;
ProductDto proDto=null;
shopdb.ProductMgr proMgr=null;
Hashtable hCart=null;

try{
	proMgr=shopdb.ProductMgr.getDao();
	
	if(session.getAttribute("mem_id")==null){
		response.sendRedirect("Login.jsp");
	}else{
		%>
		<html>
		<head>
		<link href="style.css" rel="stylesheet" type="text/css">
		<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="script.js"></script>
		</head>
		
		<body bgcolor="#996600" topmargin="100">
			<%@ include file="Top.jsp" %>
			
			<table width="80%" align="center" bgcolor="#FFFF99">
				<tr>
					<td align="center" bgcolor="#FFFFCC">
						<table width="95%" align="center" bgcolor="#FFFF99" border"1">
						
							<tr bgcolor="#996600">
								<td align="center"><font color="#FFFFFF">제품</font></td>
								<td align="center"><font color="#FFFFFF">수량</font></td>
								<td align="center"><font color="#FFFFFF">가격</font></td>
								<td align="center"><font color="#FFFFFF">수정/삭제</font></td>
								<td align="center"><font color="#FFFFFF">조회</font></td>
							</tr>
							<%
							int totalPrice=0;
							hCart=cartMgr.getCartList();
							
							if(hCart.size()==0){
								%>
								<tr><td colspan="5" align="center">
								선택하신 물품이 없습니다.
								</td>
								</tr>
								<%
							}else{
								out.println("<tr><td align=center colspan=5>장바구니에 들어있는 상품</td></tr>");
								Enumeration hCartKey=hCart.keys();
								
								while(hCartKey.hasMoreElements()){
									ordDto=(OrderDto)hCart.get(hCartKey.nextElement());
									
									proDto=proMgr.getProduct(request.getParameter("code"),ordDto.getPro_no());
									
									int price=proDto.getPrice();
									int quantity=Integer.parseInt(ordDto.getQuantity());
									int subTotal=price*quantity;
									totalPrice+=subTotal;
									
									java.util.Date date=new java.util.Date();
									java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd H:mm:ss");
									%>
									<form method="post" action="CartProc.jsp">
										<input type="hidden" name="pro_no" value="<%=proDto.getPro_no()%>">
										<input type="hidden" name="flag">
										<input type="hidden" name="state" value="2">
										
										<tr>
											<td align="center"><%=proDto.getName() %></td>
											<td align="center">
												<input type="text" name="quantity" value="<%=ordDto.getQuantity()%>" size="5">개
											</td>
											
											<td align="center"><%=subTotal+"" %></td>
											
											<td algin="center">
											<input type="button" value="cart수정" onClick="javaScript:cartUpdate(this.form)">/
											<input type="button" value="cart삭제" onClick="javaScript:cartDelete(this.form)">
											</td>
											
											<td align="center">
												<a href="javaScript:productDetail('<%=proDto.getCode() %>')">상세보기</a>
											</td>
										</tr>
									</form>
									<%
								}//while
									%>
									<tr>
										<td colspan="4" align="right">총 금액:<%=totalPrice %>원</td>
										<td align="center">
											<a href="OrderProc.jsp">주문하기</a>
										</td>
									</tr>
									<%
							}//else
							%>
						
						</table>
					</td>
				</tr>
			</table>
			
			<form name="detail" method="post" action="ProductDetail.jsp">
				<input type="hidden" name="code">
			</form>
			<%@ include file="Bottom.jsp" %>
		</body>
		</html>
		<%
	}
}catch(Exception ex1){
	out.print("");
}
%>