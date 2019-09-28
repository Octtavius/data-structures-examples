package ie.home.queues.blockingqueues;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainClass {

	public static void main(String[] args) {
//		// Creating BlockingQueue of size 10
//        // BlockingQueue supports operations that wait for the queue to become non-empty when retrieving an element, and
//        // wait for space to become available in the queue when storing an element.
        BlockingQueue<JobMessage> crunchQueue = new ArrayBlockingQueue<JobMessage>(10);
        MessageProducer crunchProducer = new MessageProducer(crunchQueue);
//        BlockingConsumer crunchConsumer = new BlockingConsumer(crunchQueue);
//        
//        // starting producer to produce messages in queue
//        new Thread(crunchProducer).start();
//        
//        // starting consumer to consume messages from queue
//        new Thread(crunchConsumer).start();
//        
//        try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
        crunchProducer.produceMessages();
        AlwaysRunningBlockingConsumer alwaysRunningBlockingConsumer = new AlwaysRunningBlockingConsumer(crunchQueue, 1);
//        AlwaysRunningBlockingConsumer alwaysRunningBlockingConsumer2 = new AlwaysRunningBlockingConsumer(crunchQueue, 2);
        new Thread(alwaysRunningBlockingConsumer).start();
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        crunchProducer.produceMessages();
//        new Thread(alwaysRunningBlockingConsumer2).start();
        
        System.out.println("Let's get started. Producer / Consumer Test Started.\n");

        
	}

}
