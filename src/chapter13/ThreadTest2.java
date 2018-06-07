package chapter13;

public class ThreadTest2 implements Runnable {

	@Override
	public void run() {
		System.out.println("["+Thread.currentThread().getName()+"]");
		System.out.println("2st 실행");
		
		for(int i=0;i<10;i++) {
			System.out.println("2st :"+i);
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
