package dataStructure;

public class LinearSearch {

	static int LSearch(int ar[], int len, int target) {
		for(int i=0;i<len;i++) {
			if(ar[i]==target) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int arr[] = {3,5,2,4,9};
		int idx;
		
		idx = LSearch(arr,arr.length,4);
		if(idx == -1)
			System.out.println("탐색 실패");
		else
			System.out.printf("타겟 저장 인덱스: %d %n",idx);
	
		idx = LSearch(arr,arr.length,7);
		if(idx == -1)
			System.out.println("탐색 실패");
		else
			System.out.printf("타겟 저장 인덱스: %d %n",idx);
		
	}

}
