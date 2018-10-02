<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%
request.setCharacterEncoding("utf-8");
%>
<html>
<body>
	<%@ include file="menu.jsp"%>

	<%
String item=request.getParameter("item");//menu.jsp, remove.jsp
String step=request.getParameter("step");
Vector vec=null;
%>

	<%
if(item!=null){//선택한 item이 있으면
	
	//장바구니 내용을 가져온다.
	vec=(Vector)session.getAttribute("cart");
	
	if(vec==null){//장바구니에 아무것도 없으면, 처음 물건을 선택했을때
		vec=new Vector();
		vec.add(item);
		session.setAttribute("cart",vec);
		
	}else{//이미 장바구니가 만들어져 있으면
		if(step.equals("add")){
		vec.add(item);
		
		}else if(step.equals("remove")){
		vec.remove(item);
		
		}
	}
	
		out.println("쇼핑 cart에 담긴 CD<br>");
	
	for(int i=0;i<vec.size();i++){
		out.println((i+1)+":"+(vec.get(i).toString())+"<br>");
	}
	%>
	현재 cart에 모두
	<%=vec.size() %>개 담겨 있습니다
	<br>
	<%
		if(vec.size()>0){
			%>
	<jsp:include page="remove.jsp" flush="true" />
	<%
		}
		
}else{
	
	out.println("쇼핑중");
}
%>
</body>
</html>
