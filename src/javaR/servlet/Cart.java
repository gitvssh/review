//package javaR.servlet;
//
//
//import java.io.*;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.*;
//
//import java.sql.*;
//import java.text.SimpleDateFormat;
//
//@WebServlet("/Cart")
//public class Cart extends HttpServlet {
//
//	private static final String DRIVER="com.mysql.jdbc.Driver";
//	private static final String URL="jdbc:mysql://localhost:3306/mydb";
//	private static final String USER="root";
//	private static final String PWD="12345";
//	
//	Connection con = null;
//	Statement stmt = null;
//	ResultSet rs = null;
//	
//	java.util.Date date = new java.util.Date();
//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss EEEE");
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
//			throws ServletException, IOException {
//		
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		
//		try{
//			Class.forName(DRIVER);
//		}catch(ClassNotFoundException cnf){
//			System.out.println("드라이버 로딩 실패 : "+cnf);
//		}
//		
//		try{
//			con=DriverManager.getConnection(URL,USER,PWD);
//			stmt=con.createStatement();
//			rs=stmt.executeQuery("select * from sangpum");
//			
//			out.println("<html><body bgcolor=margenta><br><br>");
//			out.println("<h2>(^.^)상품목록리스트(^.^)</h2>");
//			out.println("<table align=center width=70% border=1"+
//					" borderColor=green cellpadding=0 cellspacing=0>");
//			
//			while(rs.next()){
//				String title=rs.getString("title");
//				String imgfile=rs.getString("imgfile");
//				String imghtml=rs.getString("imghtml");
//				String content=rs.getString("content");
//				
//				out.println("<tr bgcolor=cyan><td>제목</td>");
//				out.println("<td align=center>"+title+"</td>");
//				out.println("</tr>");
//				
//				out.println("<tr><td colspan=2 align=center>");
//				out.println("<a href='/03_ServletProject/html01/a.jsp?imgfile="+imgfile+"&title="+title+"&content="+content+"'>");
//				
//				out.println("<img src='/03_ServletProject/imgs/"+imgfile+"' width=100 height=100>");
//				out.println("</a></td></tr>");
//				
//				out.println("<tr><td>설명</td>");
//				out.println("<td align=center>"+content+"</td></tr>");
//				
//				out.println("<tr><td colspan=2 align=center>");
//				out.println(sdf.format(date)+"</td></tr>");
//			}//while
//			
//			out.println("</table>");
//			out.println("</body></html>");
//			out.close();
//			rs.close();
//			stmt.close();
//			con.close();
//		}catch(Exception e){
//			System.out.println("SQL Exception :"+e);
//		}
//		
//	}//doGet
//
//}//class
