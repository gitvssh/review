//package utils;
//
////�Է� ������ ��ȿ�� üũ
////id , pwd 
//import logic.User;
//
//import org.springframework.util.StringUtils;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//public class LoginValidator implements Validator {
//
//	// supports�� clazz ��ü�� Validator�� ������ �������� 
//	// üũ�ϴ� �޼ҵ��Դϴ�.
//	public boolean supports(Class<?> clazz) {
//		return User.class.isAssignableFrom(clazz);
//	}
//	
//	//�������̵�
//	//validate�� ������ ������Ʈ�� ���������� üũ�ϴ� �κ��Դϴ�.
//	public void validate(Object obj, Errors errors) {
//		User user=(User)obj;
//	      
//		//id�� �����̸� �ʵ���� ������ �����Ѵ� 
//	   if(!StringUtils.hasLength(user.getUserId())) {
//			errors.rejectValue("userId", "error.required");
//			//msg.properties
//			//error.required.userId=����ID�� �Է��� �ּ���
//	   }//if
//	   
//	   //password �� �����̸� �ʵ���� ������ �����Ѵ�
//	   if (!StringUtils.hasLength(user.getPassword())) {
//			errors.rejectValue("password", "error.required");
//			//msg.properties
//			//error.required.password=�н����带 �Է��� �ּ��� 
//	   }//if
//
//	   // ���� ����� Ŭ����(User)��ü�� ���� �����̸�
//	   if (errors.hasErrors()) {
//	 		errors.reject("error.input.user");
//	 		//msg.properties
//	 		//error.input.user=�Է� ������ ������ �ֽ��ϴ�
//	   }//if
//	}//validate() end
//
//}//class
