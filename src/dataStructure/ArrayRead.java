package dataStructure;

import java.util.Scanner;

public class ArrayRead {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		int readCount = 0;
		int readData;

		while(true) {
			System.out.print("자연수 입력 : ");
			readData = sc.nextInt();
			if(readData<1) {
				break;
			}
			
			arr[readCount++] = readData;
			
				
		}
		for(int i=0;i<readCount;i++) {
			System.out.println(arr[i]);
		}
	}

}
