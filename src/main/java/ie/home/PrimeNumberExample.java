package ie.home;

public class PrimeNumberExample {
	public static void main(String args[]) {
		System.out.println(getNthPrimeNumber(100));
	}
	
	public static int getNthPrimeNumber( int num ) {
		int limit = (int) Math.pow(10, 4);
		
		int count = 0;
		for (int i = 2; i < limit; i++) {
			if (MathFunctions.isPrimeNumber(i)) {
				count++;
				
				if (count == num) {
					return i;
				}
			}
		}
		
		return -1;
	}
}
