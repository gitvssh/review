package com.spring.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.spring.service.order.CartService;

public class CartClient {
	public static void main(String args[]){
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("cart.xml");
		
		ctx.registerShutdownHook();
	}
}
