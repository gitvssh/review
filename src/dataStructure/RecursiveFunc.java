package dataStructure;

public class RecursiveFunc {

	static void Recursive(int num) {
		if(num<=0)
			return;
		System.out.printf("Recursive call! %d %n",num);
		Recursive(num-1);
	}
	
	
	public static void main(String[] args) {
		Recursive(3);
		
	}

}
