//package com.spring.service.order;
//
//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;
//
//public class CartService {
//	
//	String memId;
//	
//	public CartService(String memId){
//		this.memId = memId;
//	}
//	
//	public void afterPropertiesSet() throws Exception{
//		System.out.println(memId + ":īƮ ��� ����:InitializingBean.afterPropertiesSet()");
//	}
//	
//	public void destroy() throws Exception{
//		System.out.println(memId + ":īƮ ��� ����:DisposableBean.destroy()");
//	}
//	
//	public void loadItems(){
//		System.out.println(memId + ":īƮ ��� ����:init-method, loadItems() ȣ��");
//	}
//	
//	public void storeItems(){
//		System.out.println(memId + ":īƮ ��� ����:destroy-method, storeItems() ȣ��");
//	}
//	
//}
