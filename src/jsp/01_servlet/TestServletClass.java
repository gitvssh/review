package jsp.class1;
//package jsp;
//
//import java.io.IOException;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/tsc")
//public class TestServletClass extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//	@PostConstruct
//	public void abc() {
//		System.out.println("------postConstruct--------");
//		
//	}
//	@PreDestroy
//	public void abcd() {
//		
//	}
//    @Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//    	System.out.println("-------destroy-----");
//    }
//
//    @Override
//    public void init() throws ServletException {
//    	// TODO Auto-generated method stub
//    	System.out.println("------init--------");
//    }
//    
//	public TestServletClass() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		System.out.println("------doget--------");
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
