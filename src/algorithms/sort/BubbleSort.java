package algorithms.sort;

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

		/*�����Ʈ, �ڷḦ �յڼ����� ���ؼ� ū��,�������� �ϳ��� �̵�����, ��(or��)���� �������� �����ϴ°�
		 * ����for������ �ð����⵵ O(n^2)����, �������⵵ O(n)����
		 * ����for���� �ܺ�for������ �׻� 1��ŭ ������, ����for������ �񱳴���� ū��,�������� ��������� �������ķ� ��������,�������� ����
		 */
		//�����ۼ� 18.5.29
	}//end main

}//end class
