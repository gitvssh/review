//package member.action;
//
//import javax.servlet.http.*;
//import javax.servlet.*;
//import member.action.*;
//import java.sql.Timestamp;
//
//import ch19.action.CommandAction;
//
//public class InputProAction implements CommandAction {
//
//	@Override
//	public String requestPro(HttpServletRequest request,
//			HttpServletResponse response) throws Throwable {
//
//		request.setCharacterEncoding("utf-8");
//		
//		MemberDTO dto=new MemberDTO();
//		
//		String id=request.getParameter("id");
//		dto.setId(request.getParameter("id"));
//		dto.setPasswd(request.getParameter("passwd"));
//		dto.setName(request.getParameter("name"));
//		
//		dto.setJumin1(request.getParameter("jumin1"));
//		dto.setJumin2(request.getParameter("jumin2"));
//		dto.setEmail(request.getParameter("email"));
//		
//		dto.setZipcode(request.getParameter("zipcode"));
//		dto.setAddr(request.getParameter("addr"));
//		dto.setJob(request.getParameter("job"));
//		
//		dto.setRegdate(new Timestamp(System.currentTimeMillis()));
//		
//		MemberDAO dao=MemberDAO.getInstance();
//		dao.insertMember(dto);
//		
//		request.setAttribute("id", id);
//		return "/member/inputPro.jsp";
//	}
//
//}
