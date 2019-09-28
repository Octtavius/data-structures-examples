package ie.home.queues.blockingqueues;

import java.util.concurrent.BlockingQueue;

public class BlockingConsumer implements Runnable {
	private BlockingQueue<JobMessage> queue;

	public BlockingConsumer(BlockingQueue<JobMessage> queue) {
        this.queue = queue;
    }

	@Override
	public void run() {
		try {
			JobMessage msg;

			// consuming messages until exit message is received
			while ((msg = queue.take()).getMsg() != "exit") {
//				Thread.sleep(10);
				System.out.println("CrunchifyBlockingConsumer: Message - " + msg.getMsg() + " consumed.");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
