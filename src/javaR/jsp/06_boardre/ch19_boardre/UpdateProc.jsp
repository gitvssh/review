<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="boardre.*"
    %>
    <%--UpdateProc.jsp --%>
<%
request.setCharacterEncoding("utf-8");
boardre.BoardDao dao=new boardre.BoardDao();
%>

<%--객체 생성하고, 모든 setter 호출하여 값 세팅 --%>
<jsp:useBean id="dto" class="boardre.BoardDto">
	<jsp:setProperty name="dto" property="*"/>
</jsp:useBean>

<%
int nowPage=Integer.parseInt(request.getParameter("page"));
int num=Integer.parseInt(request.getParameter("num"));

BoardDto dto2=dao.getBoard(num);//Dao메서드 호출, 암호 가져오려고
String dbPass=dto2.getPass();//Db에서 가져온 암호
String inPass=request.getParameter("pass");//입력한 암호

//암호비교
if(inPass.equals(dbPass)){
	dao.updateBoard(dto);//Dao메서드호출, DB내용 update
	response.sendRedirect("List.jsp?page="+nowPage);
}else{//암호가 틀리면
%>
<script>
	alert("암호가 틀립니다")
	history.go(-1)
</script>
<%
}
%>