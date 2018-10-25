package com.spring.service.order;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class CartService {
	
	String memId;
	
	public CartService(String memId){
		this.memId = memId;
	}
	
	public void afterPropertiesSet() throws Exception{
		System.out.println(memId + ":카트 목록 적재:InitializingBean.afterPropertiesSet()");
	}
	
	public void destroy() throws Exception{
		System.out.println(memId + ":카트 목록 저장:DisposableBean.destroy()");
	}
	
	public void loadItems(){
		System.out.println(memId + ":카트 목록 적재:init-method, loadItems() 호출");
	}
	
	public void storeItems(){
		System.out.println(memId + ":카트 목록 저장:destroy-method, storeItems() 호출");
	}
	
}
