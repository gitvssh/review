package servlet;


import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {

	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/mydb";
	private static final String USER="root";
	private static final String PWD="12345";
	
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String db_pwd="";
		
		try{
			Class.forName(DRIVER);
		}catch(ClassNotFoundException cnf){
			System.out.println("LoginTest 드라이버 로딩 에러"+cnf);
		}
		
		try{
			con=DriverManager.getConnection(URL,USER,PWD);
			stmt=con.createStatement();
			rs=stmt.executeQuery("select pwd from member where id='"+id+"'");
			
			if(rs.next()){
				db_pwd=rs.getString("pwd");
			}
			
			if(db_pwd.equals(pwd)){
				out.println("<html><body>");
				
				out.println("<Meta http-equiv=refresh content='3;url=/03_ServletProject/Cart'>");
				out.println("<font color=blue size=5>");
				out.println(id+"님 저희 사이트를 방문해 주셔서 감사합니다</font>");
				out.println("</body></html>");
				
				
				out.close();
				rs.close();
				stmt.close();
				con.close();
			}else{
				out.println("<Meta http-equiv=refresh content='3;url=/03_ServletProject/html01/Login.html'>");
				out.println("<font color=blue size=5>");
				out.println("id,pwd 틀립니다.</font>");
				out.println("</body></html>");
				
				
				out.close();
				rs.close();
				stmt.close();
				con.close();
			}
			
		}catch(Exception e){
			System.out.println("Login sql 예외 :"+e);
		}
		
	}

}
