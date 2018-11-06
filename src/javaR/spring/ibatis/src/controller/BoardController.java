//package controller;
//
//import java.util.HashMap;
//import java.util.List;
//import javax.servlet.http.HttpServletRequest;
//import model.Board;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import board.service.BoardDaoImpl;
//
//@Controller
//@RequestMapping("/board")
//public class BoardController {
//	
//	private ApplicationContext context= 
//			new ClassPathXmlApplicationContext("/config/applicationContext.xml");
//	
//	private BoardDaoImpl boardDaoImpl=
//			(BoardDaoImpl)context.getBean("boardDaoImpl");
//	
//	@RequestMapping("/list.do")
//		public ModelAndView listBoards(){
//		List<Board> boardList = this.boardDaoImpl.getList();
//		
//		return new ModelAndView("list","boardList",boardList);
//								//뷰이름  key           value
//	}
//	
//	@RequestMapping("/write.do")
//	public String insertBoard(){
//		return "write";
//	}
//	
//	@RequestMapping(value="/write.do",method=RequestMethod.POST)
//	public String insertBoardPor(Board board,HttpServletRequest request){
//		
//		board.setIp(request.getRemoteHost());
//		this.boardDaoImpl.insertBoard(board);
//		
//		return "redirect:list.do";
//	}
//	
//	//글내용보기
//	@RequestMapping(value="/content.do")
//	public ModelAndView contentBoard(Integer num){
//		Board board=this.boardDaoImpl.getBoard(num);
//		return new ModelAndView("content","board",board);
//	}
//	
//	//글 수정 폼
//	@RequestMapping(value="/update.do",method=RequestMethod.GET)
//	public ModelAndView updateUser(Integer num){
//		Board board=this.boardDaoImpl.getBoard(num);
//		return new ModelAndView("update","board",board);
//	}
//	
//	@RequestMapping(value="/update.do",method=RequestMethod.POST)
//	public String updatePro(Board board){
//		this.boardDaoImpl.updateBoard(board);
//		return "redirect:list.do";
//		//response.sendRedirect("list.do");와 같다.
//		//redirect 는 http://를 새로 연결한다.
//	}
//	
//	@RequestMapping("/delete.do")
//	public String deletePro(Integer num){
//		this.boardDaoImpl.deleteBoard(num);
//		return "redirect:list.do";
//	}
//}
