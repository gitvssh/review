package com.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.model.product.Computer;
import com.spring.model.product.SaleItem;

public class SaleItemClient {
	public static void main(String args[]){
		
		ApplicationContext ct=new ClassPathXmlApplicationContext("saleItem.xml");
		Computer pc01=(Computer)ct.getBean("pc01");
		System.out.println(pc01.getContents());
		
		SaleItem saleItem=(SaleItem)ct.getBean("saleItem");
		System.out.println("»ý¼ºÀÚ DI");
		System.out.println(saleItem.display());
		
		SaleItem saleItem2=(SaleItem)ct.getBean("saleItem2");
		System.out.println("\n---setter Injection---");
		System.out.println(saleItem2.display());
	}
}
