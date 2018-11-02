package co.kr.memboard;

import java.io.IOException;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ibatis.session.SqlSession;
import java.util.HashMap;
import java.util.List;
import org.springframework.ui.Model;

import model.dto.BoardDto;//

@Controller
public class BoardController {
	
	//변수선언 앞에 @Autowired 붙이면 자동으로 setter작업이 된다
	@Autowired
    private SqlSession sqlSession;
	
	//글쓰기 폼
	@RequestMapping("writeForm.do")
	public String writeForm(Model model,String num,String ref,String re_step, String re_level,String pageNum) {
		
		if(num==null) {
			num="0"; ref="1"; re_step="0"; re_level="0";
		}
		
		if(pageNum==null) {
			pageNum="1";
		}
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("num",new Integer(num));
		model.addAttribute("ref",new Integer(ref));
		model.addAttribute("re_step",new Integer(re_step));
		model.addAttribute("re_level",new Integer(re_level));
		
		return "/board/writeForm";
	}//글쓰기
	
	@RequestMapping(value="/writePro.do",method=RequestMethod.POST)
	public String writeFormPro(@ModelAttribute("BoardDto")BoardDto boardDto,HttpServletRequest request) throws NamingException,IOException{
		
		int maxNum=0;
		
		if(sqlSession.selectOne("board.maxNumber")!=null) {
			maxNum=sqlSession.selectOne("board.maxNumber");
		}
		
		if(maxNum!=0) {
			maxNum=maxNum+1;
		}else {
			maxNum=1;
		}
		
		String ip=request.getRemoteAddr();
		boardDto.setIp(ip);
		
		if(boardDto.getNum()!=0) {
			sqlSession.update("board.reStep", boardDto);
			
			boardDto.setRe_step(boardDto.getRe_step()+1);
			boardDto.setRe_level(boardDto.getRe_level()+1);
		}else {
			boardDto.setRef(new Integer(maxNum));
			boardDto.setRe_step(new Integer(0));
			boardDto.setRe_level(new Integer(0));
		}
		sqlSession.insert("board.insertBoard",boardDto);
		
		return "redirect:list.do";
	}
	
	//리스트
	@RequestMapping("/list.do")
	public String list(Model model, String pageNum) throws NamingException,IOException{
		
		if(pageNum==null) {
			pageNum="1";
		}
		
		int pageSize = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow=(currentPage-1)*pageSize+1;
		int endRow=currentPage*pageSize;
		int count=0;
		int pageBlock=10;
		
		count=sqlSession.selectOne("board.selectCount");
		
		int number=count-(currentPage-1)*pageSize;
		int pageCount=count/pageSize+(count%pageSize==0?0:1);
		
		HashMap<String,Integer> map=new HashMap<String, Integer>();
		map.put("start", startRow-1);
		map.put("cnt",pageSize);
		
		List<BoardDto> list=sqlSession.selectList("board.selectList",map);
		
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("startRow",startRow);
		model.addAttribute("endRow",endRow);
		model.addAttribute("pageBlock",pageBlock);
		
		model.addAttribute("pageCount",pageCount);
		model.addAttribute("count",count);
		model.addAttribute("pageSize",pageSize);
		model.addAttribute("number",number);
		model.addAttribute("list",list);
		
		return "/board/list";
	}
	
	
}
