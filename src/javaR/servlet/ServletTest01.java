//package javaR.servlet;
//import java.io.*;
//import javax.servlet.*;
//import javax.servlet.http.*;
//
//public class ServletTest01 extends HttpServlet{
//	
//	public void doGet(HttpServletRequest req,HttpServletResponse res) 
//			throws ServletException, IOException{
//		
//		//html 페이지의 표준 MIME컨텐츠 타입 지정
//		res.setContentType("text/html;charset=euc-kr");//클라이언트로 한글을 보낼때 한글처리를 위해 설정
//		
//		PrintWriter out = res.getWriter();//out 응답 객체 생성
//		
//		out.println("<html>");
//		out.println("<body>");
//		
//		out.print("<h2>HelloWorld</h2><br>");
//		out.print("<h2>안녕하세요</h2><br>");
//		
//		out.println("</body>");
//		out.println("</html>");
//		out.close();
//	}//doGet
//	
//	
//}//class