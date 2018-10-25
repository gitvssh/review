package sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloAppClient3 {
	public static void main(String[] args){
		
		ApplicationContext ct=new ClassPathXmlApplicationContext("beans3.xml");
		MessageBean bb=(MessageBean)ct.getBean("target");
		bb.sayHello();
	}
}
