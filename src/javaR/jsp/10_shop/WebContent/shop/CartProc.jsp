<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="shopdb.*"%>

<%-- CartProc.jsp --%>

<jsp:useBean id="cartMgr" class="shopdb.CartMgr" scope="session">
</jsp:useBean>

<%-- dto에 모두 setter 작업 --%>
<jsp:useBean id="orderDto" class="shopdb.OrderDto">
	<jsp:setProperty name="orderDto" property="*"/>
</jsp:useBean>

<%
String flag=request.getParameter("flag");//update,del
String mem_id=(String)session.getAttribute("mem_id");

if(mem_id==null){//로그인 안된 상태
	response.sendRedirect("Login.jsp");//로그인 화면으로 가기
}else{//로그인상태
	if(flag==null){//장바구니에 넣기
		orderDto.setUserid(mem_id);//userid를 setter
		cartMgr.addCart(orderDto);//장바구니에 넣기
		%>
		<script>
			alert("장바구니에 담았습니다")
			location.href="CartList.jsp"
		</script>
		<%
	}else if(flag.equals("update")){
		orderDto.setUserid(mem_id);
		cartMgr.updateCart(orderDto);
		%>
		<script>
			alert("수정하였습니다")
			location.href="CartList.jsp"
		</script>
		<%
	}else if(flag.equals("del")){
		cartMgr.deleteCart(orderDto);
		%>
		<script>
			alert("삭제하였습니다")
			location.href="CartList.jsp"
		</script>
		<%
	}//else-if
}//else로그인상태
%>