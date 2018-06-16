package algorithms;

public class recurtion {

	static int sum(int[] a){
		if(a.length==1) {
			return a[0];
		}
		else {
			int[] b = new int[a.length>1?a.length-1:0];
			System.arraycopy(a, 1, b, 0, a.length-1);
			return a[0]+sum(b);
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9};
		
		System.out.println(sum(a));
		
			
	}

}
