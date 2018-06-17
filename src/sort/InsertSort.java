package sort;

public class InsertSort {

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
		
		
		int i,key,j;
		
		for(i=1;i<10;i++) {
			key = list[i];
			j=i-1;
			while(j>=0&&list[j]>key) {
				list[j+1]=list[j];
				j=j-1;
			}
			list[j+1]=key;
			l.print(list);
		}
		l.print(list);
	}

}
