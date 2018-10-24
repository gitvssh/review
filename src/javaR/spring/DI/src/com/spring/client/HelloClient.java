package com.spring.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import com.spring.hello.HelloService;

public class HelloClient {
	public static void main(String[] args){
		//1. BeanFactory를 이용한 Container 생성
//		BeanFactory factory=new XmlBeanFactory(new ClassPathResource("hello.xml"));
//		HelloService service=(HelloService)factory.getBean("helloService");
//		service.sayHello();
		
		//2. ApplicationContext를 이용한 Container 생성
		//FileSystemXmlApplicationContext를 이용한 빈 참조, 경로 꼭 확인
//		String xmlFile="C:\\_java\\03_spring\\02_Srping_DI\\xml\\hello.xml";
//		ApplicationContext fileCtx=new FileSystemXmlApplicationContext(xmlFile);
//		HelloService service1=(HelloService)fileCtx.getBean("helloService");
//		service1.sayHello();
		
		//3.ClassPathXmlApplicationContext를 이용한 빈 참조
//		ApplicationContext classCtx=new ClassPathXmlApplicationContext("hello.xml");
//		HelloService service2=(HelloService)classCtx.getBean("helloService");
//		service2.sayHello();
		
		//spring.xml 만들어서
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
//		HelloService service3=(HelloService)ctx.getBean("helloService");
//		service3.sayHello();
		
		//별칭사용
//		HelloService service4=(HelloService)ctx.getBean("hello");
//		service4.sayHello();
		
		//5. Factory를 이용한 빈 참조
		ApplicationContext ctx2=new ClassPathXmlApplicationContext("spring.xml");
		HelloService helloBean=(HelloService)ctx2.getBean("helloBean");
		helloBean.sayHello();
	}
}
