//package co.kr.memboard;
//
//import java.io.IOException;
//import javax.naming.NamingException;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.ibatis.session.SqlSession;
//import java.util.HashMap;
//import java.util.List;
//import org.springframework.ui.Model;
//
//import model.dto.MemberDto;//
//
//@Controller
//public class MemberController {
//
//	//�������� �տ� @Autowired ���̸� �ڵ����� setter�۾��� �ȴ�
//	@Autowired
//    private SqlSession sqlSession;
//
//	/*public void setSqlSession(SqlSession sqlSession) {
//		this.sqlSession = sqlSession;
//	}*/
//    
//	@RequestMapping("/main.do")
//	public String mainTest() {
//		return "main";// views/main.jsp �� ����
//	}//
//
//	
//	//ȸ��������
//	@RequestMapping("/insertForm.do")
//	public String userWrite() {
//		return "/member/insertForm";// ��
//		// views/member/���������
//	}//
//
//	//idCheck.do
//	//idCheck.jsp ���
//	@RequestMapping(value="/idCheck.do", method=RequestMethod.POST)
//	public String idCheck(String id,Model model) throws NamingException,IOException
//	{
//		int check=-1;
//		MemberDto memberDto=sqlSession.selectOne("member.selectOne", id);
//		 
//		if(memberDto==null){
//			check=1;//��� ������ id
//		}
//		model.addAttribute("check",check);
//		return "member/idCheck";// �丮��
//	 }//-----
//
//	//ȸ������
//	@RequestMapping(value="/insertPro.do", method=RequestMethod.POST)
//	public String memberInsert(@ModelAttribute("MemberDto") MemberDto memberDto
//			,String addr,String details,HttpServletRequest request) throws NamingException,IOException
//			{
//			System.out.println("addr:"+addr);
//			System.out.println("request.getParameter(addr):"+request.getParameter("addr"));
//			
//			memberDto.setAddr(addr+" "+details);//settr
//	 		sqlSession.insert("member.insertMember", memberDto);
//			//return "redirect:list.do";
//			return "member/login";//���̸�
//	}//---
//
//	//�α��� ��
//	@RequestMapping("/login.do")
//	public String userLogin() {
//		return "member/login";// ��
//	}// ---
//
//	//�α���,����ó��
//	@RequestMapping(value="/loginPro.do", method=RequestMethod.POST)
//	public String memberLogin(String id,String passwd,Model model)
//			throws NamingException,IOException
//		{
//		HashMap <String,String>map=new HashMap<String,String>();
//		map.put("id",id);
//		map.put("passwd",passwd);
//		
//		MemberDto memberDto=sqlSession.selectOne("member.selectLogin", map);
//		 
//		if(memberDto==null){//�α��� ����
//			model.addAttribute("msg","�α��� ����!!!");
//			return "member/login";//login.jsp
//		}//if
//		//�α��� ����������
//		model.addAttribute("memberDto",memberDto);
//		return "member/loginSuccess";//�� ���� , loginSuccess.jsp
//	}//---
//
//	//�α� �ƿ�
//	@RequestMapping("/logOut.do")
//	public String memOut() {
//		return "member/logOut";//�� logOut.jsp
//	}//---
//
//	//ȸ������ ������
//	@RequestMapping(value="/editForm.do",method=RequestMethod.POST)
//	public String editForm(String id,Model model) throws NamingException,IOException{
//		
//		MemberDto memberDto=sqlSession.selectOne("member.selectOne",id);
//		model.addAttribute("memberDto",memberDto);
//		return "member/editForm";
//	}
//	
//	//ȸ�� ����
//	@RequestMapping(value="/editPro.do", method=RequestMethod.POST)
//	public String editPro(@ModelAttribute("MemberDto") MemberDto memberDto,String npwd) throws NamingException,IOException{
//		memberDto.setPasswd(npwd);
//		sqlSession.update("member.memberUpdate",memberDto);
//		return "main";
//	}
//	
//	//ȸ��Ż��
//	@RequestMapping(value="/memberDelete.do", method=RequestMethod.POST)
//	public String userDelete(String id) throws NamingException,IOException{
//		sqlSession.delete("member.memberDelete", id);
//		return "main";
//	}
//}//class
