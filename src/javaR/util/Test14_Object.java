package javaR.util;

import static java.lang.System.out;

class Test{}

public class Test14_Object {
	public static void main(String[] args){
		Test A=new Test();
		Test B=new Test();
		Test C=new Test();
		
		out.println("A클래스 이름:"+A.getClass());
		out.println("A해쉬코드:"+A.hashCode());
		out.println("A객체문자열"+A.toString());
		System.out.println();
	}
}
