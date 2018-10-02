<%@ page info="예제07" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>page 객체</h2>

info:<%=this.getServletInfo() %><br>
서블릿이름:<%=this.getServletName() %><br>
클래스 : <%=this.getClass() %><br>

</body>
</html>