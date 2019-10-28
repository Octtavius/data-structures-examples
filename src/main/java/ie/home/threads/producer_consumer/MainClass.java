package ie.home.threads.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

import ie.home.threads.Consumer;


public class MainClass {
	public static void main (String[] args) {
		Queue<String> q = new LinkedList<>();
	    boolean exit = false;
	    Producer p = new Producer(q, exit);
	    new Thread(p).start();
	    Consumer c = new Consumer(q, exit);
	    new Thread(c).start();
	}
}
