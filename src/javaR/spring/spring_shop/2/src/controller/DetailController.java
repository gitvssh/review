//package controller;
//
//import java.util.*;
//
//import logic.*;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class DetailController {
//
//	private Shop shopService;
//
//	public void setShopService(Shop shopService) {
//		this.shopService = shopService;
//	}
//	
//	/*
//	 * 임의의 메서드 앞에
//	 * 요청 어노테이션 부여함으로써
//	 * 요청을 처리하는 메서드로 지정할 수 있다.
//	 */
//	@RequestMapping 
//	public ModelAndView detailItem(Integer item_id){
//		
//		Item item=this.shopService.getItemByItemId(item_id);
//		
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("item", item);
//		
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("detail");
//		mv.addAllObjects(map);
//		
//		return mv;
//	}
//	
//}
