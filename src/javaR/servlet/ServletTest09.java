//package javaR.servlet;
//
//import java.io.*;
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/ServletTest09")
//public class ServletTest09 extends HttpServlet {
//       
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
//			throws ServletException, IOException {
//		response.setContentType("text/html;charset=utf-8");
//		request.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		
//		String id=request.getParameter("id");
//		String pwd=request.getParameter("pwd");
//		String name=request.getParameter("name");
//		
//		out.println("<html>");
//		out.println("<body bgcolor='cyan'>");
//		
//		out.println("id : "+id+"<br>");
//		out.println("pwd : "+pwd+"<br>");
//		out.println("name : "+name+"<br>");
//		
//		out.println("</body>");
//		out.println("</html>");
//		out.close();
//	}
//
//}
