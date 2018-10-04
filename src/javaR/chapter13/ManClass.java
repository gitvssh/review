package javaR.chapter13;

public class ManClass {

	public static void main(String[] args) {
		ThreadTest threadTest = new ThreadTest();
		ThreadTest02 threadTest02 = new ThreadTest02();
		
		Thread thread = new Thread(threadTest,"A");
//		Thread thread2 = new Thread(threadTest2,"B");
		threadTest02.start();
		thread.start();
//		thread2.start();
//		thread3.start();
		
		System.out.println("["+Thread.currentThread().getName()+"]");
		System.out.println("MainClass");
		System.out.println("MainClass 끝");
	}

}
