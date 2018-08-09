package java.chapter13;

public class MultiTest implements Runnable {

	int testNum = 0;

	@Override
	public synchronized void run() {
		for (int i = 0; i < 10; i++) {
			if (Thread.currentThread().getName().equals("A")) {
				System.out.println("========================================");
				testNum++;
			}
			System.out.println("Thread Name : "+Thread.currentThread().getName() + ", testNum : " + testNum);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
