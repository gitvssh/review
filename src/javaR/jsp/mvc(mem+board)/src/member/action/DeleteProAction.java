//package member.action;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import ch19.action.CommandAction;
//import member.action.*;
//
//public class DeleteProAction implements CommandAction {
//
//	@Override
//	public String requestPro(HttpServletRequest request,
//			HttpServletResponse response) throws Throwable {
//		
//		String id=request.getParameter("id");
//		String passwd=request.getParameter("passwd");
//		
//		MemberDAO dao=MemberDAO.getInstance();
//		int check=dao.deleteMember(id, passwd);
//		
//		request.setAttribute("check", new Integer(check));
//		
//		return "/member/deletePro.jsp";
//	}
//
//}
