package ie.home.recursions;

public class RecursionExample {

	public static int sum(int n) {
	    if (n >= 1) {
	        return sum(n - 1) + n;
	    }
	    return n;
	}
	
//	public static int doesNumberFit() {
//	    if (n >= 1) {
//	        return sum(n - 1) + n;
//	    }
//	    return n;
//	}
	
	public static void main(String[] args) {
		int minG = 2;
		int maxG = 3;
		System.out.println(sum(5));
	}
}
