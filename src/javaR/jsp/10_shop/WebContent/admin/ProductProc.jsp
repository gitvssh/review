<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="shopdb.*"%>

<%--ProductProc.jsp--%>

<%
request.setCharacterEncoding("utf-8");//post 요청 한글처리
ProductMgr proMgr=ProductMgr.getDao();
%>

<jsp:useBean id="ordMgr" class="shopdb.OrderMgr"/>

<%
String flag=request.getParameter("flag");
boolean result=false;

int iti=0;

if(flag.equals("insert")){
	result=proMgr.insertProduct(request);
	response.sendRedirect("ProductList.jsp");
}else if(flag.equals("update")){
	result=proMgr.updateProduct(request);
	response.sendRedirect("ProductList.jsp");
}else if(flag.equals("del")){
	Vector vec=ordMgr.getOrderList();
	if(vec.size()==0){//주문목록에 없으면
		int im=Integer.parseInt(request.getParameter("pro_no"));
		result=proMgr.deleteProduct(request,im);
		response.sendRedirect("ProductList.jsp");
	}else{//주문목록이 있으면
		for(int i=0;i<vec.size();i++){
			OrderDto order=(OrderDto)vec.get(i);
			int pro_no=order.getPro_no();
			
			if(pro_no==Integer.parseInt(request.getParameter("pro_no"))){
				iti++;
			}
		}//for
		
		if(iti==0){//주문 상황이 아니면, 삭제
			int im_pro_no=Integer.parseInt(request.getParameter("pro_no"));
			result=proMgr.deleteProduct(request,im_pro_no);
			response.sendRedirect("ProductList.jsp");
		}else{//주문상황이면
			result=false;
		%>
			<script>
				alert("주문 상태라서 삭제 못함")
				location.href="ProductList.jsp"
			</script>
		
		<%
		}
	}//vec
}else{//위의 조건에 맞지 않는 경우, 상품 목록 보기
	response.sendRedirect("ProductList.jsp");
}//flag
%>