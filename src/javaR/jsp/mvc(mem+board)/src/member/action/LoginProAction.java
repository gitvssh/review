//package member.action;
//
//import ch19.action.CommandAction;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import member.*;
//
//public class LoginProAction implements CommandAction{
//
//	@Override
//	public String requestPro(HttpServletRequest request,
//			HttpServletResponse response) throws Throwable {
//		
//		request.setCharacterEncoding("utf-8");
//		String id=request.getParameter("id");
//		String passwd = request.getParameter("passwd");
//		
//		MemberDAO dao=MemberDAO.getInstance();
//		int check=dao.userCheck(id,passwd);
//		
//		request.setAttribute("check", new Integer(check));
//		request.setAttribute("id", id);
//		request.setAttribute("memId",id);
//		
//		
//		return "/member/loginPro.jsp";
//	}
//	
//}
