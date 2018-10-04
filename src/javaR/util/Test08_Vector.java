package javaR.util;
//Vector : 객체자료처리하기 위한 자료형
//vector 는 스레드 기능이 잇다.
//게시판 : vector, list<-arraylist
//list는 스레드 기능이 없다
import java.util.Vector;
import javaR.util.*;

public class Test08_Vector {
	public static void main(String args[]){
		
		Vector<String> vec = new Vector<String>();
		
		for(int i=0;i<args.length;i++){
			vec.add(args[i]);
		}
		
		String str="";
		
		vec.remove(2);
		
		for(int i=0;i<vec.size();i++){
			
			str=(String)vec.get(i);
			System.out.println("vec :"+i+" 번째 요소 :"+str);
		}
		System.out.println();
	}
}
