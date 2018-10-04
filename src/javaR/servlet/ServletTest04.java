package javaR.servlet;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServletTest04 extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		
		if(id.equals("admin")&&pwd.equals("12345")){
			out.println("<html><body bgcolor='cyan'>");
			out.println("<font size=5 color=blue>");
			out.println(id+"님의 방문을 환영합니다");
			out.println("</font></body></html>");
			out.close();
			
		}else{
			out.println("<html><body bgcolor='yellow'>");
			out.println("<Meta http-equiv=refresh content=\"2;url=/02_servletProject/html01/ServletTest04.html\">");
			out.println("<font size=5 color=red>");
			out.println("비밀번호가 틀렸습니다.");
			out.println("</font></body></html>");
			out.close();
			
		}
			
		
	}
}
