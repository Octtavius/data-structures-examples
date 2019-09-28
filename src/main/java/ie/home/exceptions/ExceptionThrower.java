package ie.home.exceptions;

public class ExceptionThrower {
	
	public static void nestedExceptions() {
		try {
            meth();
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught");
        } finally {
            System.out.println("Outer finally");
        }
	}
	
	private static void meth() {
        try {
            int res = 3 / 0;
        } 
        finally {
            System.out.println("Finally in meth");
        }
    }
}
