package sort;

public class SelectionSort {

	public static void main(String[] args) {
		ExamList l = new ExamList();
		
		int[] list = new int[10];//기본배열 10개 생성
		
		for(int i=0;i<10;i++) {//1~10 숫자 대입
			list[i] = i+1;
		}
		for(int i=0;i<1000;i++) {//1000회 랜덤숫자섞기
			int tmp =0;
			int tmp_num = (int)(Math.random()*10);
			tmp = list[tmp_num];
			list[tmp_num]=list[0];
			list[0]=tmp;
		}
		l.print(list);
		
		int selected;//선택된 숫자 넣을 변수
		int selected_num;//선택된 숫자 배열위치
		
		
		for(int i=0;i<10;i++) {
			selected = list[i];
			selected_num = i;
			for(int j=i;j<10;j++) {
				if(list[j]<selected) {
					selected=list[j];
							selected_num = j;
				}
			}
			list[selected_num]=list[i];
			list[i]=selected;
		}
		
		l.print(list);
		/*선택정렬, 오름차순 내림차순은, 내부for문의 대소크기중 어떤것을 고르느냐에 따라 선택
		 * 외부for문의 진행방향이 정렬의 진행방향
		 * 시간복잡도 O(n^2),공간복잡도 O(1)
		 * 최초작성 18.5.29 
		 */
	}//end main

}//end class
