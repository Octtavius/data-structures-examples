package ie.home;

public class MathFunctions {

	private static int power(int n1, int n2) {
		int result = 1;
		
		for (int i = 1; i < n2; i++) {
			result *= n1;
		}
		
		return result;
	}
	
	public static boolean isPrimeNumber(int num) {
		int i, middle = 0;

		middle = num / 2;
		
		if (num == 0 || num == 1) {
			System.out.println(num + " is not prime number");
			return false;
		} else {
			for (i = 2; i <= middle; i++) {
				if (num % i == 0) {
					System.out.println(num + " is not prime number");
					return false;
				}
			}
		}
		return true;
	}
}
