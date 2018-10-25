package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping("resultPage")
	public ModelAndView helloWorld(){
		String msg="world";
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("resultPage");
		mv.addObject("msg", msg);
		
		return mv;
	}
}
