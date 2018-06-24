package algorithms;

public class Recurtion2 {

	static int count(int[] list) {
		if(list.length==1) {
			return 1;
		}else {
			int[] b = new int[list.length-1];
			System.arraycopy(list, 1, b, 0, list.length-1);
			return 1+count(b);
		}
	}
	
	public static void main(String[] args) {
		int[] list = {1,2,3,4,5,1,2,3,4,5,1,2,3,4,5};
		System.out.println(count(list));
	}

}
