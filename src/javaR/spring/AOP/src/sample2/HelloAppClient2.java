package sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloAppClient2 {
	public static void main(String args[]){
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans2.xml");
		MessageBean bb=(MessageBean)ctx.getBean("target");
		bb.sayHello();
	}
}
