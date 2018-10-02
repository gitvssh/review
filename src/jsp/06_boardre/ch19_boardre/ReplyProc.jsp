<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="boardre.*"
    %>
    <%--ReplyProc.jsp --%>

<%
request.setCharacterEncoding("utf-8");
boardre.BoardDao dao=new boardre.BoardDao();
%>

<%-- 모든 파라미터값을 받아서 dto에 저장 --%>
<jsp:useBean id="dto" class="boardre.BoardDto">
	<jsp:setProperty name="dto" property="*"/>
</jsp:useBean>

<%
int nowPage=Integer.parseInt(request.getParameter("page"));
int num=Integer.parseInt(request.getParameter("num"));

BoardDto dto2=dao.getBoard(num);//dao 메서드 호출
int pos=dto2.getPos();//현재글 위치 얻기
int depth=dto2.getDepth();//글 깊이 얻기

dto.setPos(pos);//모델빈에 setter
dto.setDepth(depth);

dao.replyPos(dto);//dao 메서드 호출, pos(글 위치 확보)
dao.replyBoard(dto);//dao 답글 쓰기 메서드 호출

response.sendRedirect("List.jsp?page="+nowPage);
%>
