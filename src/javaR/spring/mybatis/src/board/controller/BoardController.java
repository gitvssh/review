//package board.controller;
//
//import java.io.*;
//import java.util.*;
//
//import javax.naming.*;
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSession;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.stereotype.Controller;
//
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import org.springframework.web.servlet.ModelAndView;
//import board.model.BoardDto;
//
////컨트롤러 == Action에 해당한다.
//@Controller
//public class BoardController {
//	
//	@Autowired
//	SqlSessionTemplate sst;//변수 이부분을 @Autowired
//	
//	@RequestMapping("list.do")
//	public ModelAndView listAll() throws NamingException,IOException{
//		
//		SqlSession ssession = sst.getSqlSessionFactory().openSession();
//		List list=ssession.selectList("board.selectAll");//네임스페이스.id명
//		ssession.close();
//		return new ModelAndView("list","list",list);
//		//						view	key		value
//	}
//	
//	@RequestMapping("/write.do")
//	public String boardWrite(){
//		return "writeForm";
//	}
//	
//	//insert
//	@RequestMapping(value="/write.do",method=RequestMethod.POST)
//	public String boardWritePro(@ModelAttribute("boardDto")BoardDto boardDto)
//			throws NamingException,IOException{
//		//mybatis사용
//		SqlSession session=sst.getSqlSessionFactory().openSession();
//		session.insert("board.insertBoard",boardDto);
//		//				네임스페이스.id			파라미터값
//		session.commit();
//		session.close();
//		return "redirect:list.do";//response.sendRedirect("list.do")
//	}
//	
//	//글내용보기
//	@RequestMapping("content.do")
//	public ModelAndView getOneBoard(int num){
//		SqlSession session=sst.getSqlSessionFactory().openSession();
//		
//		//조회수
//		session.update("board.readcountBoard",new Integer(num));
//		session.commit();
//		
//		//글내용보기
//		BoardDto boardDto=(BoardDto)session.selectOne("board.selectOne",num);
//		session.close();
//		
//		//ModelAndView mv=new ModelAndView();
//		//mv.setViewName("content");
//		//mv.addObject("boardDto",boardDto);//Map 타입으로 객체 지정
//		//return mv;
//		return new ModelAndView("content","boardDto",boardDto);
//	}
//	
//	//글수정 폼
//	@RequestMapping(value="/edit.do", method=RequestMethod.GET)
//	public ModelAndView userEdit(int num){
//		
//		SqlSession session=sst.getSqlSessionFactory().openSession();
//		BoardDto boardDto=(BoardDto)session.selectOne("board.selectOne",num);
//		session.close();
//		return new ModelAndView("edit","boardDto",boardDto);
//	}
//	
//	//글수정
//	@RequestMapping(value="/edit.do",method=RequestMethod.POST)
//	public String updateBoard(@ModelAttribute("boardDto") BoardDto boardDto) throws NamingException,IOException{
//		SqlSession session=sst.getSqlSessionFactory().openSession();
//		session.update("board.updateBoard",boardDto);
//		System.out.println(boardDto.getWriter());
//		session.commit();
//		session.close();
//		return "redirect:list.do";
//	}
//	
//	//글삭제
//	@RequestMapping("delete.do")
//	public String deleteBoard(int num) throws NamingException,IOException{
//		SqlSession session=sst.getSqlSessionFactory().openSession();
//		session.delete("board.deleteBoard",num);
//		session.commit();
//		session.close();
//		return "redirect:lidt.do";
//	}
//}
