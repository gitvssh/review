package algorithms.sort;

public class SelectionSort {

	public static void main(String[] args) {
		ExamList l = new ExamList();
		
		int[] list = new int[10];//�⺻�迭 10�� ����
		
		for(int i=0;i<10;i++) {//1~10 ���� ����
			list[i] = i+1;
		}
		for(int i=0;i<1000;i++) {//1000ȸ �������ڼ���
			int tmp =0;
			int tmp_num = (int)(Math.random()*10);
			tmp = list[tmp_num];
			list[tmp_num]=list[0];
			list[0]=tmp;
		}
		l.print(list);
		
		int selected;//���õ� ���� ���� ����
		int selected_num;//���õ� ���� �迭��ġ
		
		
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
		/*��������, �������� ����������, ����for���� ���ũ���� ����� �����Ŀ� ���� ����
		 * �ܺ�for���� ��������� ������ �������
		 * �ð����⵵ O(n^2),�������⵵ O(1)
		 * �����ۼ� 18.5.29 
		 */
	}//end main

}//end class
