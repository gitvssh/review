package sort;

public class ExamList {

	public static void main(String[] args) {

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
	}//end main

	void print(int[] list) {
		for(int i =0;i<list.length;i++) {
			System.out.printf("%d,",list[i]);
		}
		System.out.println();
	}
	
}//end class
