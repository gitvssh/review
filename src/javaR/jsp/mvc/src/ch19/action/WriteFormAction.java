//package javaR.jsp.mvc.src.ch19.action;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//
//public class WriteFormAction implements CommandAction{
//
//	@Override
//	public String requestPro(HttpServletRequest request,
//			HttpServletResponse response) throws Throwable {
//		//원글, 답글 처리
//		int num=0, ref=1, re_step=0, re_level=0; 
//		try{
//			if(request.getParameter("num")!=null){
//				num=Integer.parseInt(request.getParameter("num"));
//				ref=Integer.parseInt(request.getParameter("ref"));
//				re_step=Integer.parseInt(request.getParameter("re_step"));
//				re_level=Integer.parseInt(request.getParameter("re_level"));
//			}
//		}catch(Exception ex){
//			
//		}//tc
//		
//		request.setAttribute("num", new Integer(num));
//		request.setAttribute("ref", new Integer(ref));
//		request.setAttribute("re_step",  new Integer(re_step));
//		request.setAttribute("re_level",  new Integer(re_level));
//		
//		return "/ch19/writeForm.jsp";
//	}//requestPro()
//
//}
