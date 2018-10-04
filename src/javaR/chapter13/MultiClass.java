package javaR.chapter13;

public class MultiClass {

	public static void main(String[] args) {

		MultiTest multiTest = new MultiTest();
		
		Thread thread0 = new Thread(multiTest,"A");
		Thread thread1 = new Thread(multiTest,"B");
		
		thread0.start();
		thread1.start();
		
		System.out.println(Thread.currentThread().getName());
		System.out.println("Main메소드 실행, 종료");
	}

}
