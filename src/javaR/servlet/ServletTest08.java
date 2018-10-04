package javaR.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "설명", urlPatterns = { "/ServletTest08" })
public class ServletTest08 extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");

		PrintWriter out = res.getWriter();

		out.println("<html>");
		out.println("<body bgcolor=yellow>");
		out.println("<h2>어노테이션 연습</h2>");
		out.println("<h3>어노테이션 사용 하면 web.xml에 서블릿을 등록하는 것과 같은 기능을 합니다.</h3>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
