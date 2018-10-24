//package ch19.action;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import boardmysql.*;
//
//
////http://ip:port/컨텍스트이름/ch19/writePro.do
//public class WriteProAction implements CommandAction{
//
//	@Override
//	public String requestPro(HttpServletRequest request,
//			HttpServletResponse response) throws Throwable {
//		
//		request.setCharacterEncoding("utf-8");//post요청 한글처리
//		BoardDTO dto=new BoardDTO();
//		
//		dto.setNum(Integer.parseInt(request.getParameter("num")));
//		dto.setWriter(request.getParameter("writer"));
//		dto.setEmail(request.getParameter("email"));
//		dto.setSubject(request.getParameter("subject"));
//		dto.setPasswd(request.getParameter("passwd"));
//		
//		dto.setRef(Integer.parseInt(request.getParameter("ref")));
//		dto.setRe_step(Integer.parseInt(request.getParameter("re_step")));
//		dto.setRe_level(Integer.parseInt(request.getParameter("re_level")));
//		dto.setContent(request.getParameter("content"));
//		dto.setIp(request.getRemoteAddr());
//		
//		BoardDAO dao=BoardDAO.getDao();
//		dao.insertArticle(dto);
//		
//		return "/ch19/writePro.jsp";
//	}
//
//}
