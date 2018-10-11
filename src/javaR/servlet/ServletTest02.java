//package javaR.servlet;
//import java.io.*;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//
//import java.text.SimpleDateFormat;
//import javaR.util.*;
//
//
//public class ServletTest02 extends HttpServlet {
//	//doGet override
//	public void doGet(HttpServletRequest req, HttpServletResponse res) 
//			throws ServletException,IOException{
//		
//		res.setContentType("text/html;charset=utf-8");//클라이언트에 응답할때 한글 처리
//		PrintWriter out = res.getWriter();//클라이언트로 응답하기 위한 out객체 생성
//		
//		java.util.Date date = new java.util.Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd H:mm:ss EEEE");
//		
//		out.println("<html>");
//		out.println("<body bgcolor=yellow>");
//		out.println("<font color='blue' size='5'>");
//		
//		out.println("<center><br><br><br>");
//		
//		out.println("<img src=\'./imgs/beach.png\'>");
//		
//		out.println("<marquee>");
//		out.println("오늘은 행복한 금요일입니다... 내일은 즐거운 토요일입니다.");
//		out.println("</marquee>");
//		
//		out.println("<br><br><hr size=10 color=red><br>");
//		
//		out.println(date.toString());
//		out.println("<br>");
//		out.println(sdf.format(date));
//		
//		out.println("</center>");
//		out.println("</font>");
//		out.println("</body>");
//		out.println("</html>");
//		out.close();
//		
//	}//doGet
//}//class
