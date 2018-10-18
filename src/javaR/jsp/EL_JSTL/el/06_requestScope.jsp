<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--06_requestScope.jsp--%>

<br>
파라미터값 id : ${param.id }<br>
파라미터값 pwd :${param.pwd }<br>
<br>

<%--
http://~~ 06_requestScope.jsp?id=kim&pwd=12345
--%>

요청URI : ${pageContext.request.requestURI}<br>
요청URL : ${pageContext.request.requestURL}<br>

<%--
요청URI : /11_EL/el/06_requestScope.jsp
요청URL : http://localhost:9001/11_EL/el/06_requestScope.jsp
--%>