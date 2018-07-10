package dataStructure.chapter1;

public class C1BinarySearch {

	static int BSearch(int ar[], int len, int target) {
		int first = 0;
		int last = len-1;
		int mid;
		
		while(first <= last) {
			mid = (first+last)/2;
			
			if(target == ar[mid]) {
				return mid;
			}
			else {
				if(target<ar[mid])
					last = mid-1;
				else
					first = mid+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,3,5,7,9};
		int idx;
		
		idx = BSearch(arr,arr.length,7);
		if(idx == -1)
			System.out.println("탐색 실패");
		else
			System.out.printf("타겟 저장 인덱스 : %d %n",idx);
		
		idx = BSearch(arr,arr.length,4);
		if(idx == -1)
			System.out.println("탐색 실패");
		else
			System.out.printf("타겟 저장 인덱스 : %d %n",idx);
		
		
		
	}

}
