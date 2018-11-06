//package com.spring.client;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import com.spring.model.product.Computer;
//import com.spring.model.product.Notebook;
//
//public class AbstractClient {
//	public static void main(String args[]){
//		ApplicationContext ctx=new ClassPathXmlApplicationContext("abstract.xml");
//		
//		Computer pc1=(Computer)ctx.getBean("pc1");
//		System.out.println(pc1.getContents());
//		System.out.println();
//		
//		Notebook note1=(Notebook)ctx.getBean("note1");
//		System.out.println(note1.getContents());
//		System.out.println();
//		
//		Computer pc2=(Computer)ctx.getBean("pc2");
//		System.out.println(pc2.getContents());
//		System.out.println();
//		
//		Notebook note2=(Notebook)ctx.getBean("note2");
//		System.out.println(note2.getContents());
//		System.out.println();
//		
//	}
//}
