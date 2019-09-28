package ie.home.queues.blockingqueues;

import java.util.concurrent.BlockingQueue;

public class MessageProducer implements Runnable {

	private BlockingQueue<JobMessage> crunchQueue;

	public MessageProducer(BlockingQueue<JobMessage> queue) {
		this.crunchQueue = queue;
	}

	@Override
	public void run() {
		produceMessages();
	}

	public void produceMessages() {
		// producing CrunchifyMessage messages
		for (int i = 1; i <= 5; i++) {
			JobMessage msg = new JobMessage("i'm msg " + i);
			try {
				Thread.sleep(200);
				crunchQueue.put(msg);
				System.out.println("CrunchifyBlockingProducer: Message - " + msg.getMsg() + " produced.");
			} catch (Exception e) {
				System.out.println("Exception:" + e);
			}
		}

		// adding exit message
		JobMessage msg = new JobMessage("All done from Producer side. Produced 50 CrunchifyMessages");
		try {
			crunchQueue.put(msg);
			System.out.println("CrunchifyBlockingProducer: Exit Message - " + msg.getMsg());
		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}
	}
}
