package controller;

import logic.*;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginFormController {

	private Shop shopService;
	private Validator loginValidator;
	
	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}
	public void setLoginValidator(Validator loginValidator) {
		this.loginValidator = loginValidator;
	}
	
	/*
	 * login 뷰 이름을 반환, get 요청이 들어오면
	 * 로그인 하면 표시(web-inf/jsp/login.jsp
	 * login.html 요청시, 처리되어 지는 메서드
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String toLoginView(){
		return "login";
	}
	
	/*
	 * jsp에서
	 * <form:form modelAttribute="user">
	 */
	@ModelAttribute
	public User setUpForm(){
		return new User();
	}
	
	//id와 pwd 입력하고 로그인(sign in)누르면 이 메서드 처리된다.
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(User user, BindingResult bindingResult){
		
		//BindingResult 인스턴스는 검증 결과가 저장된 것이다.
		this.loginValidator.validate(user, bindingResult);//입력항목 검증;
		//검증 대상은 User 인스턴스와,
		//검증 결과를 저장할 BindingResult 인스턴스를 건내줍니다.
		
		ModelAndView mv=new ModelAndView();
		
		if(bindingResult.hasErrors()){
			mv.getModel().putAll(bindingResult.getModel());
			return mv;
		}//에러가 있으면 로그인화면으로 되돌아갑니다.
		
		try{
			//유저 정보 검색
			User loginUser=this.shopService.getUserByUserIdAndPassword(user.getUserId(), user.getPassword());
			
			//유저가 있을떄
			mv.setViewName("loginSucces");//뷰이름(로그인 성공)
			mv.addObject("loginUser",loginUser);//뷰에서 사용할 데이터
			
			return mv;
		}catch(EmptyResultDataAccessException e){
			//유저가 없을때
			bindingResult.reject("error.login.user");//에러 메시지 설정하고
			mv.getModel().putAll(bindingResult.getModel());//모델을 리턴
			return mv;
		}
	}
}
