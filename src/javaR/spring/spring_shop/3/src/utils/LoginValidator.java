package utils;

//입력 데이터 휴효성 체크
//id , pwd 
import logic.User;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {

	// supports는 clazz 객체가 Validator로 검증이 가능한지 
	// 체크하는 메소드입니다.
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}
	
	//오버라이딩
	//validate는 검증할 오브젝트를 실질적으로 체크하는 부분입니다.
	public void validate(Object obj, Errors errors) {
		User user=(User)obj;
	      
		//id가 공백이면 필드오류 정보를 설정한다 
	   if(!StringUtils.hasLength(user.getUserId())) {
			errors.rejectValue("userId", "error.required");
			//msg.properties
			//error.required.userId=유저ID를 입력해 주세요
	   }//if
	   
	   //password 가 공백이면 필드오류 정보를 설정한다
	   if (!StringUtils.hasLength(user.getPassword())) {
			errors.rejectValue("password", "error.required");
			//msg.properties
			//error.required.password=패스워드를 입력해 주세요 
	   }//if

	   // 검증 대상인 클래스(User)자체에 대한 오류이면
	   if (errors.hasErrors()) {
	 		errors.reject("error.input.user");
	 		//msg.properties
	 		//error.input.user=입력 정보에 문제가 있습니다
	   }//if
	}//validate() end

}//class
