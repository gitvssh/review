package ch19.action;

import javax.servlet.*;
import javax.servlet.http.*;
import boardmysql.*;

public class UpdateProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		String pageNum=request.getParameter("pageNum");
		
		BoardDTO dto=new BoardDTO();
		
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		dto.setWriter(request.getParameter("writer"));
		dto.setEmail(request.getParameter("email"));
		
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		dto.setPasswd(request.getParameter("passwd"));
		
		BoardDAO dao=BoardDAO.getDao();
		int check=dao.updateArticle(dto);
		
		request.setAttribute("check", new Integer(check));
		request.setAttribute("pageNum", new Integer(pageNum));
		
		return "/ch19/updatePro.jsp";
	}

}
