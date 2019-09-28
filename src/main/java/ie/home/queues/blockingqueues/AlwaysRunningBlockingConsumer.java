package ie.home.queues.blockingqueues;

import java.util.concurrent.BlockingQueue;

public class AlwaysRunningBlockingConsumer implements Runnable {
	private BlockingQueue<JobMessage> queue;
	private int id;

	public AlwaysRunningBlockingConsumer(BlockingQueue<JobMessage> queue, int id) {
        this.queue = queue;
        this.id = id;
    }

	@Override
	public void run() {
		
		while(true) {
			System.out.println("thread "+id+" running");
			try {
				JobMessage message = queue.take();
//				System.out.println("processing the message");
				System.out.println(message.getMsg());
//			// consuming messages until exit message is received
//			while ((msg = queue.take()).getMsg() != "exit") {
				Thread.sleep(1000);
//				System.out.println("CrunchifyBlockingConsumer: Message - " + msg.getMsg() + " consumed.");
//			}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			try {
//				JobMessage msg;
//				
//				JobMessage message = queue.take();
//				System.out.println("processing the message");
////			// consuming messages until exit message is received
////			while ((msg = queue.take()).getMsg() != "exit") {
//////				Thread.sleep(10);
////				System.out.println("CrunchifyBlockingConsumer: Message - " + msg.getMsg() + " consumed.");
////			}
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
}
