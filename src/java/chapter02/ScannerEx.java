package java.chapter02;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
input : while(true) {
System.out.println("���ڸ� ������ �ϳ� �Է����ּ���.>");
String input = scanner.nextLine();
try {
int num = Integer.parseInt(input);
System.out.println("�Է³��� :"+input);
System.out.printf("num=%d%n",num);
break;
}
catch(Exception e){
System.out.println("�����Դϴ�.");
continue input;
}
}
System.out.println("�����Է� �Ǿ����ϴ�.");
	}

}
