<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%--06_number.jsp--%>

<h2>JSTL fmt 예제 formatNumberic, formatData</h2>

number(숫자표시) :
<fmt:formatNumber value="12345.678" type="number"/>
<br>

currency(통화기호) :
<fmt:formatNumber value="12345.678" type="currency" currencySymbol="￦"/>
<br>

percent(퍼센트) :
<fmt:formatNumber value="12.3" type="percent"/>
<br>

pattern : ".0":
<fmt:formatNumber value="12345.678" pattern=".0"/><br>