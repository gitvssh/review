//package ch19.action;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import boardmysql.*;
//
//public class ContentAction implements CommandAction {
//
//	@Override
//	public String requestPro(HttpServletRequest request,
//			HttpServletResponse response) throws Throwable {
//		
//		int num=Integer.parseInt(request.getParameter("num"));
//		String pageNum=request.getParameter("pageNum");
//		
//		BoardDAO dao=BoardDAO.getDao();
//		BoardDTO dto=dao.getArticle(num);
//		
//		request.setAttribute("num",new Integer(num));
//		request.setAttribute("pageNum", new Integer(pageNum));
//		
//		String content=dto.getContent();
//		content=content.replace("\n","<br>");
//		request.setAttribute("content", content);
//		
//		int ref=dto.getRef();
//		int re_step=dto.getRe_step();
//		int re_level=dto.getRe_level();
//		
//		request.setAttribute("ref", new Integer(ref));
//		request.setAttribute("re_step", new Integer(re_step));
//		request.setAttribute("re_level", new Integer(re_level));
//		
//		request.setAttribute("dto",dto);
//		
//		return "/ch19/content.jsp";
//	}
//
//}
