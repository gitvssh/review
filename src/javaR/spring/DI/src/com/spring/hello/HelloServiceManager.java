package com.spring.hello;

//요청을 받는 클래스
//이클립스가 하는 일은 일하는 클래스 객체를 클라이언트에게 리턴
public class HelloServiceManager {
	public static HelloService getInstance(){
		return new HelloServiceImpl();//일하는 클래스를 리턴
	}//getInstance()
}//class
