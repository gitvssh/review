package dataStructure;

public class C2RecursiveBinarySearch {
	static int BsearchRecur(int ar[],int first, int last, int target) {
		int mid;
		if(first>last) {
			return -1;
		}
		mid = (first+last)/2;
		
		if(ar[mid]==target) {
			return mid;
		}else if(target < ar[mid]) {
			return BsearchRecur(ar, first, mid-1, target);
		}else {
			
			return BsearchRecur(ar, mid+1, last, target);
		}
			
	}
	
	public static void main(String[] args) {
		int arr[] = {1,3,5,7,9};
		int idx;
		
		idx = BsearchRecur(arr, 0, arr.length, 7);
		if(idx==-1) {
			System.out.println("탐색실패");
		}else {
			System.out.println("타겟 저장 인덱스: "+idx);
		}
		
		idx = BsearchRecur(arr, 0, arr.length, 4);
		if(idx==-1) {
			System.out.println("탐색실패");
		}else {
			System.out.println("타겟 저장 인덱스: "+idx);
		}
		
		
			
	}

}
