package com.spring.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.model.Config;

public class ConfigClient {
	public static void main(String args[]){
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
			
		Config cart=(Config)ctx.getBean("config");
		System.out.println(cart.toString());
	}
}
