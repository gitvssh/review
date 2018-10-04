package javaR.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletTest07 extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		
		String name=req.getParameter("name");
		String addr=req.getParameter("addr");
		String tel = req.getParameter("tel");
		
		out.println("<html>");
		out.println("<body bgcolor=ivory>");
		
		out.println("이름 : "+name+"<br>");
		out.println("주소 : "+addr+"<br>");
		out.println("전화 : "+tel+"<br>");
		
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

}
