//package com.spring.client;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.spring.model.CollectionBean;
//
//public class CollectionClient {
//	public static void main(String args[]){
//		
//		ApplicationContext ctx=new ClassPathXmlApplicationContext("collection.xml");
//		
//		CollectionBean listRefBean=(CollectionBean)ctx.getBean("listRefBean");
//		listRefBean.printItemList();
//		System.out.println();
//		
//		CollectionBean setRefBean=(CollectionBean)ctx.getBean("setRefBean");
//		setRefBean.printItemSet();
//		System.out.println();
//		
//		CollectionBean mapRefBean=(CollectionBean)ctx.getBean("mapRefBean");
//		mapRefBean.printItemMap();
//		System.out.println();
//	}
//}
