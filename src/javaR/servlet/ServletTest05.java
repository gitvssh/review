//package javaR.servlet;
//import java.io.*;
//import javax.servlet.*;
//import javax.servlet.http.*;
//
//
//public class ServletTest05 extends HttpServlet{
//	
//	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
//		res.setContentType("text/html;charset=utf-8");
//		req.setCharacterEncoding("utf-8");
//		
//		PrintWriter out = res.getWriter();
//		
//		String fruit[] =req.getParameterValues("fruit");
//		
//		out.println("<html><body bgcolor='cyan'>");
//		out.println("<font size=5 color=blue>");
//		if(fruit!=null){
//			out.println("당신이 선택한 과일은 <br>");
//			for(int i=0;i<fruit.length;i++){
//				out.println(fruit[i]);
//			}
//		}else{
//			out.println("선택한 과일이 없습니다.");
//		}
//		out.println("</font></body></html>");
//		out.close();
//		
//		
//	}
//}
