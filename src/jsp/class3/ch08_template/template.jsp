<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- template.jsp --%>
<%
String pageFile=request.getParameter("page");

if(pageFile==null){
	pageFile="newItem";
}
%>

<html>
<body bgcolor="orange">

<table width="90%" height="99%" border="1" align="center" bgColor="#cccccc">

<%--상단메뉴 --%>
<tr>
	<td height="43" colspan="3" align="right">
		<jsp:include page="top.jsp"/>
	</td>
</tr>
<%--왼쪽메뉴 --%>
<tr>
	<td width="15%" align="right" valign="top">
		<jsp:include page="left.jsp"/>
	</td>
</tr>
<%--중앙배치, 본문내용 --%>
<tr>
	<td colspan="2" align="center">
		<jsp:include page='<%=pageFile+".jsp" %>'/>
	</td>
</tr>

<tr>
	<td width="100%" colspan="3" height="40">
		<jsp:include page="bottom.jsp"/>
	</td>
</tr>

</table>

</body>
</html>