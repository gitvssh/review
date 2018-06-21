import java.io.BufferedReader;
import java.util.*;
public class Practice {

	public static void main(String[] args) {
//		List list = new LinkedList();
//		
//		Iterator it = list.iterator();
//		it.hasNext();
//		it.next();
//		Map map = new HashMap();
//		Set est = map.entrySet();
		Scanner scan = new Scanner("100/80/90/50/400");
		scan.useDelimiter("/");
		while(scan.hasNext()) {
		hackzum(Integer.parseInt(scan.next()));
		}
		scan.close();
	}
	
	static void hackzum(int num) {
		if(num>=90){
			System.out.println("학점 : A");
		}
		else if(num>=80){
			System.out.println("학점 : B");
		}
		else if(num>=70){
			System.out.println("학점 : C");
		}
		else{
			System.out.println("학점 : D");
		}
	}
}

