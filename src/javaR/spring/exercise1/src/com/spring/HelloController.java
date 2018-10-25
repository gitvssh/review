package com.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public ModelAndView hello(){
		String msg="Hello, Spring 3.0!";
		
		return new ModelAndView("hello","msg",msg);
								//뷰이름  객체이름  객체값
	}
}
