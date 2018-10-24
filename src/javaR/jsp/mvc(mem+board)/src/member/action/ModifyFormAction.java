//package member.action;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import member.action.*;
//
//import ch19.action.CommandAction;
//
//public class ModifyFormAction implements CommandAction {
//
//	@Override
//	public String requestPro(HttpServletRequest request,
//			HttpServletResponse response) throws Throwable {
//		
//		String id=request.getParameter("id");
//		
//		MemberDAO dao=MemberDAO.getInstance();
//		MemberDTO dto=dao.getMember(id);
//		
//		request.setAttribute("dto", dto);
//		
//		return "/member/modifyForm.jsp";
//	}
//
//}
