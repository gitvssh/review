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

import model.dto.MemberDto;//

@Controller
public class MemberController {

	//변수선언 앞에 @Autowired 붙이면 자동으로 setter작업이 된다
	@Autowired
    private SqlSession sqlSession;

	/*public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}*/
    
	@RequestMapping("/main.do")
	public String mainTest() {
		return "main";// views/main.jsp 뷰 리턴
	}//

	
	//회원가입폼
	@RequestMapping("/insertForm.do")
	public String userWrite() {
		return "/member/insertForm";// 뷰
		// views/member/폴더만들고
	}//

	//idCheck.do
	//idCheck.jsp 사용
	@RequestMapping(value="/idCheck.do", method=RequestMethod.POST)
	public String idCheck(String id,Model model) throws NamingException,IOException
	{
		int check=-1;
		MemberDto memberDto=sqlSession.selectOne("member.selectOne", id);
		 
		if(memberDto==null){
			check=1;//사용 가능한 id
		}
		model.addAttribute("check",check);
		return "member/idCheck";// 뷰리턴
	 }//-----

	//회원가입
	@RequestMapping(value="/insertPro.do", method=RequestMethod.POST)
	public String memberInsert(@ModelAttribute("MemberDto") MemberDto memberDto
			,String addr,String details,HttpServletRequest request) throws NamingException,IOException
			{
			System.out.println("addr:"+addr);
			System.out.println("request.getParameter(addr):"+request.getParameter("addr"));
			
			memberDto.setAddr(addr+" "+details);//settr
	 		sqlSession.insert("member.insertMember", memberDto);
			//return "redirect:list.do";
			return "member/login";//뷰이름
	}//---

	//로그인 폼
	@RequestMapping("/login.do")
	public String userLogin() {
		return "member/login";// 뷰
	}// ---

	//로그인,인증처리
	@RequestMapping(value="/loginPro.do", method=RequestMethod.POST)
	public String memberLogin(String id,String passwd,Model model)
			throws NamingException,IOException
		{
		HashMap <String,String>map=new HashMap<String,String>();
		map.put("id",id);
		map.put("passwd",passwd);
		
		MemberDto memberDto=sqlSession.selectOne("member.selectLogin", map);
		 
		if(memberDto==null){//로그인 실패
			model.addAttribute("msg","로그인 실패!!!");
			return "member/login";//login.jsp
		}//if
		//로그인 성공했을때
		model.addAttribute("memberDto",memberDto);
		return "member/loginSuccess";//뷰 리턴 , loginSuccess.jsp
	}//---

	//로그 아웃
	@RequestMapping("/logOut.do")
	public String memOut() {
		return "member/logOut";//뷰 logOut.jsp
	}//---

	//회원정보 수정폼
	@RequestMapping(value="/editForm.do",method=RequestMethod.POST)
	public String editForm(String id,Model model) throws NamingException,IOException{
		
		MemberDto memberDto=sqlSession.selectOne("member.selectOne",id);
		model.addAttribute("memberDto",memberDto);
		return "member/editForm";
	}
	
	//회원 수정
	@RequestMapping(value="/editPro.do", method=RequestMethod.POST)
	public String editPro(@ModelAttribute("MemberDto") MemberDto memberDto,String npwd) throws NamingException,IOException{
		memberDto.setPasswd(npwd);
		sqlSession.update("member.memberUpdate",memberDto);
		return "main";
	}
	
	//회원탈퇴
	@RequestMapping(value="/memberDelete.do", method=RequestMethod.POST)
	public String userDelete(String id) throws NamingException,IOException{
		sqlSession.delete("member.memberDelete", id);
		return "main";
	}
}//class
