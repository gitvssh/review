//package ch19.action;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.*;
//import boardmysql.*;
//
////Action은 jsp의 로직부분을 Action에서 코딩한다.
////Action은 dao메서드 호출, 결과 얻어서 setAttribute(key,value) 넣는다.
//public class ListAction implements CommandAction{
//
//	@Override
//	public String requestPro(HttpServletRequest request,
//			HttpServletResponse response) throws Throwable {
//		
//		String pageNum=request.getParameter("pageNum");
//		if(pageNum==null){
//			pageNum="1";
//		}
//		
//		int pageSize=10;//한 페이지의 글 갯수
//		int currentPage=Integer.parseInt(pageNum);//현재 페이지
//		
//		int startRow=(currentPage-1)*pageSize+1;//한 페이지의 시작 글번호
//		int endRow=currentPage*pageSize;//한 페이지의 마지막 글번호
//		
//		int count=0;//총 글갯수 넣을 변수
//		int number=0;//글번호 처리
//		int pageBlock=10;
//		
//		List articleList=null;
//				
//		BoardDAO dao=BoardDAO.getDao();//dao객체 얻기
//		
//		count=dao.getArticleCount();//dao메서드 호출, 총 글갯수얻기
//		
//		if(count>0){
//			articleList=dao.getList(startRow, pageSize);
//		}else{
//			articleList=Collections.EMPTY_LIST;
//		}
//		
//		number=count-(currentPage-1)*pageSize;//글목록에 표시할 글번호
//		int pageCount=count/pageSize+(count%pageSize==0?0:1);//페이지 수
//		
//		//해당 뷰에서 사용할 속성을 setAttribute() 해놓는다.
//		request.setAttribute("currentPage", new Integer(currentPage));
//		request.setAttribute("startRow",new Integer(startRow));
//		request.setAttribute("endRow",new Integer(endRow));
//		
//		request.setAttribute("pageBlock", new Integer(pageBlock));
//		request.setAttribute("pageCount", new Integer(pageCount));
//		
//		request.setAttribute("count", new Integer(count));
//		request.setAttribute("pageSize", new Integer(pageSize));
//		request.setAttribute("number", new Integer(number));
//		request.setAttribute("articleList", articleList);
//		
//		return "/ch19/list.jsp";
//	}
//	
//}
