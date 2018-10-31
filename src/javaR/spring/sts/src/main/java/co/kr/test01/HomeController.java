package co.kr.test01;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//추가
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/board")
	public String board(Locale locale, Model model) {
		
		String msg="안녕하세요";
		model.addAttribute("msg",msg);
		return "board";
	}
	
	@RequestMapping("/aaa")
	public String aaa(Model model) {
		HashMap<String, String> map=new HashMap<String,String>();
		map.put("name", "1");
		List<HashMap<String,String>> list=sqlSession.selectList("userControlMapper.selectSample",map);
		
		model.addAttribute("list",list);
		return "aaa";
	}
	
	@RequestMapping("/list")
	public ModelAndView boardList() {
         
        List<HashMap<String, String>> list = sqlSession.selectList("board.selectAll");
        System.out.println(list.toString());
 		return new ModelAndView("list","list",list);
	}// boardList()---

	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	//insert
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String userWritePro(@ModelAttribute("boardDto") BoardDto boardDto, HttpServletRequest request) throws NamingException,IOException{
		String ip=request.getRemoteAddr();
		boardDto.setIp(ip);
		
		sqlSession.insert("board.insertBoard",boardDto);
		return "redirect:list";
	}
	
	//조회수 증가, 글내용 보기
	@RequestMapping("/content")
	public ModelAndView getOneBoard(int num) {
		sqlSession.update("board.readcountBoard", new Integer(num));
		
		BoardDto boardDto = (BoardDto)sqlSession.selectOne("board.selectOne",num);
		
		return new ModelAndView("content","boardDto",boardDto);
	}
	
}
