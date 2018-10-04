package javaR.chapter11;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javaR.util.*;
public class IteratorEx1 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		
		Map map = new HashMap();
		map.put("1","a");
		map.put("2","b");
		map.put("3","c");
		map.put("4","d");
		map.put("5","e");
		
		Iterator itmap = map.entrySet().iterator();
		
		while(itmap.hasNext()) {
			Object obj = itmap.next();
			System.out.println(obj);
		}
	}
}
