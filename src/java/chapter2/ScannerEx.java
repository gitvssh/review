package chapter2;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
input : while(true) {
System.out.println("두자리 정수를 하나 입력해주세요.>");
String input = scanner.nextLine();
try {
int num = Integer.parseInt(input);
System.out.println("입력내용 :"+input);
System.out.printf("num=%d%n",num);
break;
}
catch(Exception e){
System.out.println("오류입니다.");
continue input;
}
}
System.out.println("정상입력 되었습니다.");
	}

}
