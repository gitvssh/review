package javaR.servlet;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.util.Enumeration;
import javaR.util.*;

public class ServletTest06 extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<head><title>라디오 버튼></title></head>");
		out.println("<body bgcolor=pink>");
		
		out.println("<center><h2>라디오버튼 테스트</h2></center>");
		out.println("당신이 선택한 자료 입니다<br>");
		
		Enumeration en = req.getParameterNames();
		
		while(en.hasMoreElements()){
			out.println("<li>");
			String name=(String)en.nextElement();
			out.println(name);
			
			out.println(":");
			String v=(String)req.getParameter(name);
			out.println(v);
		}//while
		
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}//doGet
}//class
