package ie.home;
//
//import org.junit.After;
//import org.junit.Before;

import org.junit.Test;

public class CombinationTest {

//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}

	@Test
	public void test1() {
		Room r2 = new Room(60961872, "TWIN", "2019-04-01", "2019-04-08", 1, 2, 130, "pp");
		Room r5 = new Room(60961880, "TWIN", "2019-04-01", "2019-04-08", 1, 2, 150, "pp");
		Room r3 = new Room(60961873, "DOUBLE", "2019-04-01", "2019-04-08", 2, 2, 100, "pp");
		Room r4 = new Room(60961874, "DOUBLE", "2019-04-01", "2019-04-08", 2, 2, 120, "pp");
		Room set[] = {r2, r5, r3, r4}; 
		 int n = set.length; 
		  
	        // Run a loop for printing all 2^n 
	        // subsets one by one 
	        for (int i = 0; i < (1<<n); i++) 
	        { 
	            System.out.print("{ "); 
	            int minCapacity = 0;
	            double price = 0;
	            // Print current subset 
	            for (int j = 0; j < n; j++) {
	                if ((i & (1 << j)) > 0) {
	                	price += set[j].getPrice();
	                	minCapacity += set[j].getMinGuests();
	                	System.out.print(set[j].getMinGuests() + " "); 
	                }
	            }
	  
	            if (minCapacity >= 3) {	            	
	            	System.out.println(" }" + price ); 
	            } else {
	            	
	            	System.out.println(" }"); 
	            }
	        } 
	}

}
