//package javaR.servlet;
//
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import java.sql.*;
//
//@WebServlet("/MemberInput")
//public class MemberInput extends HttpServlet {
//
//	private static final String DRIVER="com.mysql.jdbc.Driver";
//	private static final String URL="jdbc:mysql://localhost:3306/mydb";
//	private static final String USER="root";
//	private static final String PWD="12345";
//	
//	Connection con=null;
//	Statement stmt=null;
//	ResultSet rs=null;
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
//			throws ServletException, IOException {
//		response.setContentType("text/html;charset=utf-8");
//		request.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		
//		String name = request.getParameter("name").trim();
//		String id = request.getParameter("id").trim();
//		String pwd=request.getParameter("pwd").trim();
//		String email=request.getParameter("email").trim();
//		
//		String tel=request.getParameter("tel").trim();
//		String addr=request.getParameter("addr").trim();
//		
//		String db_pwd="";
//		
//		try{
//			Class.forName(DRIVER);
//			System.out.println("드라이버 로딩 성공");
//		}catch(ClassNotFoundException cnf){
//			System.out.println("드라이버 로딩 실패 :"+cnf);
//		}
//		
//		try{
//			con=DriverManager.getConnection(URL,USER,PWD);
//			System.out.println("DB연결 성공");
//			
//			stmt=con.createStatement();
//			rs=stmt.executeQuery("select pwd from member where id='"+id+"'");
//			
//			if(rs.next()){
//				db_pwd=rs.getString("pwd");
//			}
//			
//			if(db_pwd.equals("")){
//				String sql="insert into member"+
//						" values('"+id+"','"+pwd+"','"+name+"','"+
//							email+"','"+tel+"','"+addr+"')";
//				
//				stmt.executeUpdate(sql);
//				
//				out.println("<html><body>");
//				
//				out.println("<Meta http-equiv=refresh content=\"2;url=/03_ServletProject/html01/Login.html\">");
//				out.println("<font color=blue size=5>"+id+"님 회원 가입을 축하 합니다</font>");
//				out.println("</body></html>");
//				rs.close();
//				stmt.close();
//				con.close();
//				out.close();
//			}else{//사용중인 아이디와 패스워드가 있을시
//				out.println("<html><body>");
//				out.println("<Meta http-equiv=refresh content=\"3;url=/03_ServletProject/html01/MemberForm.html\">");
//				
//				out.println("<font color=blue size=5>"+id+"이 아이디는 사용중인 ID입니다.</font>");
//				
//				out.println("</body></html>");
//				out.close();
//			}
//		}catch(Exception e){
//			System.out.println("DB연결 실패 :"+e);
//		}
//	}//doPost
//
//}//class
