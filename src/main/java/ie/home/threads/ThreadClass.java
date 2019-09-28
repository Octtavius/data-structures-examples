package ie.home.threads;

public class ThreadClass implements Runnable{

	private boolean RUNNING = true;
	@Override
	public void run() {
		int count = 0;
		while (RUNNING) {
			System.out.println("Hello from thread");
			count++;
			try {
				Thread.sleep(1000);
				if (count > 5) {
					throw new InterruptedException("fake throw");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				count = 0;
				
			}
		}
		
	}

}
