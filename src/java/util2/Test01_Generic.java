package java.util2;

import java.util.*;

public class Test01_Generic {
	
	public static void testCollection(){
		List<String> list = new ArrayList();
		list.add(new String("hello"));
		list.add(new String("good"));
		
		outPrint(list);
	}
	
	private static void outPrint(Collection c){
		Iterator it=c.iterator();
		
		while(it.hasNext()){
			String item=(String)it.next();
			System.out.println(item);
		}
	}
	
	public static void main(String[] args){
		Test01_Generic a= new Test01_Generic();
		a.testCollection();
	}
}
