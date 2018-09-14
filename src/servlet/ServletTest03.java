package servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletTest03 extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException,IOException{
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String content=req.getParameter("content");
		
		out.println("<html>");
		out.println("<body bgcolor=yellow>");
		
		out.print("당신의 이름은 : "+name+"<br>");
		out.print("<h2>안녕하세요</h2><br>");
		out.print("당신의 이메일은 : "+email+"<br>");
		
		out.print("글내용<br>"+content+"<br>");
		
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
