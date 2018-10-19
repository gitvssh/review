<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%--04_msg.jsp--%>
<%--
<fmt:setLocale value="en"/>
<fmt:setLocale value="ja"/>
 --%>
<fmt:setLocale value="ko"/>

<fmt:bundle basename="resource.testBundle">
<html>
<body>
<h2>JSTL fmt 예제 bundle message</h2>

<fmt:message key="name"/><br>
<fmt:message key="MSG"/><br>

<fmt:message key="MSG" var="mm"/>
<c:out value="${mm }"/><%--변수내용 출력 --%>

</body>
</html>
</fmt:bundle>