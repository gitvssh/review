//package member.action;
//
//import javax.servlet.http.*;
//
//import member.action.*;
//import ch19.action.CommandAction;
//
//public class modifyPro implements CommandAction{
//
//	@Override
//	public String requestPro(HttpServletRequest request,
//			HttpServletResponse response) throws Throwable {
//		
//		request.setCharacterEncoding("utf-8");
//		String id=request.getParameter("id");
//		
//		MemberDTO dto=new MemberDTO();
//		
//		dto.setPasswd(request.getParameter("passwd"));
//		dto.setName(request.getParameter("name"));
//		dto.setEmail(request.getParameter("email"));
//		
//		dto.setId(request.getParameter("id"));
//		dto.setZipcode(request.getParameter("zipcode"));
//		dto.setAddr(request.getParameter("addr"));
//		dto.setJob(request.getParameter("job"));
//		
//		MemberDAO dao=MemberDAO.getInstance();
//		dao.updateMember(dto);
//		
//		request.setAttribute("id", id);
//		
//		return "/member/modifyPro.jsp";
//	}
//
//}
