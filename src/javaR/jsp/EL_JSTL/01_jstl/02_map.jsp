<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--02_map.jsp--%>
<h1>이전 방식의 HashMap사용</h1>
<%
Map<String,String> map2= new HashMap<String,String>();
map2.put("name","이순신");
map2.put("addr","서울 노량진");
map2.put("tel","02-456-6978");
%>

이름:<%=map2.get("name")%><br>
주소:<%=map2.get("addr")%><br>
전화:<%=map2.get("tel")%><br>

<h1>EL,JSTL,HashMap 사용</h1>
<c:set var="map" value="<%=new HashMap() %>" scope="page"/>

<c:set target="${map }" property="name" value="홍길동"/>
<c:set target="${map }" property="addr" value="서울 종로구"/>
<c:set target="${map }" property="tel" value="010-1234-1234"/>

<%--출력--%>
이름:${map.name}<br>
주소:${map.addr}<br>
전화:${map.tel}<br>

<%--dto모델빈과 map은 같은 방법으로 사용--%>