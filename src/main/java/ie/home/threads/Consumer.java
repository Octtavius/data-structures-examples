package ie.home.threads;

import java.util.Queue;

public class Consumer implements Runnable {
	private volatile Queue<String> sharedQueue;
	private volatile boolean bExit;

	public Consumer(Queue<String> myQueue, boolean bExit) {
		this.sharedQueue = myQueue;
		this.bExit = bExit;
	}

	@Override
	public void run() {
		while (!bExit) {
		      synchronized (sharedQueue) {
		        while (!sharedQueue.isEmpty()) {
		        	try {
		        		Thread.sleep(2000);
		        	} catch (InterruptedException e) {
		        		// TODO Auto-generated catch block
		        		e.printStackTrace();
		        	}
		          String item = sharedQueue.poll();
		          System.out.println("Consumer removed : " + item);
		          System.out.println("Consumer notifying Producer: " + item);
		          sharedQueue.notify();
		        }
		      }
		    }
	}

}
