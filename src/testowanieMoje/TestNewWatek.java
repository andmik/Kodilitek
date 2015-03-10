package testowanieMoje;

public class TestNewWatek {

	public static void main(String[] args) {
		
		Runnable r2 = new MainNewWatek2();
		Thread t2 = new Thread(r2);
		t2.start();
		
		try {
			t2.join();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Runnable r1 = new MainNewWatek();
		Thread t1 = new Thread(r1);
		t1.start();
		

		

	}

}
