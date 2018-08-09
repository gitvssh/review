package sort;

public class BubbleSort {

	public static void main(String[] args) {
		int[] list = {1,3,5,7,9,0,2,4,8,10};
		int tmp;
//		for(int i=9;i>1;i--) {//Ascending bubble sort from back to forward
//			for(int j=9;j>0;j--) {
//				if(list[j]<list[j-1]) {
//					tmp = list[j];
//					list[j]=list[j-1];
//					list[j-1]=tmp;
//					System.out.printf("%d,%d,%d,%d,%d,%d,%d,%d,%d,%d%n",list[0],list[1],list[2],list[3],list[4],list[5],list[6],list[7],list[8],list[9]);
//				}//end if
//			}//end for_j
//		}//end for_i
		
//		for(int i=9;i>1;i--) {
//			for(int j=9;j>0;j--) {//decending bubble sort from back to forward
//				if(list[j]>list[j-1]) {
//					tmp = list[j];
//					list[j] = list[j-1];
//					list[j-1]=tmp;
//					System.out.printf("%d,%d,%d,%d,%d,%d,%d,%d,%d,%d%n",list[0],list[1],list[2],list[3],list[4],list[5],list[6],list[7],list[8],list[9]);
//				}
//			}
//		}
		
//		for(int i=0;i<10;i++) {//ascending bubble sort from forward to back
//			for(int j=0;j<9;j++) {
//				if(list[j]>list[j+1]) {
//					tmp = list[j+1];
//					list[j+1]=list[j];
//					list[j]=tmp;
//					System.out.printf("%d,%d,%d,%d,%d,%d,%d,%d,%d,%d%n",list[0],list[1],list[2],list[3],list[4],list[5],list[6],list[7],list[8],list[9]);
//				}
//			}
//		}

		for(int i=0;i<10;i++) {//decending bubble sort from forward to back
			for(int j=0;j<9;j++) {
				if(list[j]<list[j+1]) {
					tmp = list[j+1];
					list[j+1]=list[j];
					list[j]=tmp;
					System.out.printf("%d,%d,%d,%d,%d,%d,%d,%d,%d,%d%n",list[0],list[1],list[2],list[3],list[4],list[5],list[6],list[7],list[8],list[9]);
				}
			}
		}

		/*버블소트, 자료를 앞뒤순서로 비교해서 큰것,작은것을 하나씩 이동시켜, 앞(or뒤)부터 차곡차곡 정렬하는것
		 * 이중for문으로 시간복잡도 O(n^2)구조, 공간복잡도 O(n)구조
		 * 내부for문은 외부for문보다 항상 1만큼 적으며, 내부for문에서 비교대상중 큰것,작은것을 어느쪽으로 보내느냐로 오름차순,내림차순 결정
		 */
		//최초작성 18.5.29
	}//end main

}//end class
