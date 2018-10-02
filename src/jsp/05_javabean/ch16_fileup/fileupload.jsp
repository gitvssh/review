<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="upload.*"
    %>

<jsp:useBean id="bb" class="upload.FileUploadBean" scope="request"/>

<%=bb.upload(request)%>
