package javaR.chapter13;

public class MainClass02 {

	public static void main(String[] args) {
		ThreadTest02 threadTest02 = new ThreadTest02();
		
		threadTest02.setName("B");
		threadTest02.start();
		
		System.out.println("["+Thread.currentThread().getName()+"]");
	}

}
