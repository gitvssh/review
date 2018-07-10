package dataStructure.chapter2;

public class C2HanoiTowerSolu {
	
	static void HanoiTowerMove(int num, char from, char by, char to) {
		if(num==1) {
			System.out.printf("원반1을 %c에서 %c로 이동  %n",from,to);
		}else {
			HanoiTowerMove(num-1,from,to,by);
			System.out.printf("원반%d을(를) %c에서 %c로 이동 %n",num,from,to);
			HanoiTowerMove(num-1,by,from,to);
		}
	}
	
	public static void main(String[] args) {
		HanoiTowerMove(10,'A','B','C');
		
	}

}
