package javaR.chapter13;

public class ThreadTest implements Runnable {

	@Override
	public void run() {
		System.out.println("["+Thread.currentThread().getName()+"]");
		System.out.println("1st 실행");
		int a = 0;
		for(int i=0;i<10;i++) {
			System.out.println("1st :"+i);
			System.out.println(a);
			a++;
			try {
				Thread.sleep(5000);
			} catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}

}
