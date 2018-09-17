package java.util;
import java.util.*;

public class Test09_Vector_Enum {

	public static void main(String[] args){
		String s1 = "hello1";
		String s2 = "hello2";
		String s3 = "hello3";
		
		Vector<String> vec2 = new Vector<String>();
		vec2.add(s1);
		vec2.add(s2);
		vec2.add(s3);
		
		System.out.println("vec.size() :"+vec2.size());
		
		for(int i=0;i<vec2.size();i++){
			System.out.println((String)vec2.get(i));
		}
		System.out.println();
		
		Enumeration en = vec2.elements();
		
		while(en.hasMoreElements()){
			System.out.println((String)(en.nextElement()));
		}//end while
	}//end main
}
