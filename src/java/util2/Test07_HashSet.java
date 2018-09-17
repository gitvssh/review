package java.util2;

import java.util.*;

public class Test07_HashSet {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("인사과");
		set.add("총무과");
		set.add("인사과");
		set.add("총무과");
		set.add("회계");
		
		System.out.println("size :"+set.size());
		for(String str:set){
			System.out.println(str);
		}
		System.out.println();
	}

}
