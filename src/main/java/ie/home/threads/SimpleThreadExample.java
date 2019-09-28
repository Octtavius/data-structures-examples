package ie.home.threads;

public class SimpleThreadExample {

	public static void main(String[] args) {
		ThreadClass myThread = new ThreadClass();
		
		new Thread(myThread).start();
	}
}
