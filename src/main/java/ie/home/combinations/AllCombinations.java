package ie.home.combinations;

import java.util.ArrayList;
import java.util.List;

import ie.home.Room;

public class AllCombinations {
	   /* arr[]  ---> Input Array 
    data[] ---> Temporary array to store current combination 
    start & end ---> Staring and Ending indexes in arr[] 
    index  ---> Current index in data[] 
    r ---> Size of a combination to be printed */
    public static void combinationUtil(List<Room> arr, int n, int r, int index, 
                                List<Room> data, int i) 
    { 
        // Current combination is ready to be printed, print it 
        if (index == r) 
        { 
        	double price = 0;
        	
            for (int j=0; j<r; j++) {
            	price += data.get(j).getPrice();
//            	System.out.print(data.get(j)+" ");
            }
            	
//            System.out.println(""); 
            System.out.println(price/4); 
            return; 
        } 
  
        // When no more elements are there to put in data[] 
        if (i >= n) {        	
        	return; 
        }
        
        // current is included, put next at next location 
        data.add(index,arr.get(i)); 
        combinationUtil(arr, n, r, index+1, data, i+1); 
  
        // current is excluded, replace it with next (Note that 
        // i+1 is passed, but index is not changed) 
        combinationUtil(arr, n, r, index, data, i+1); 
    } 
  
    // The main function that prints all combinations of size r 
    // in arr[] of size n. This function mainly uses combinationUtil() 
    public static void printCombination(List<Room> arr, int n, int r) 
    { 
        // A temporary array to store all combination one by one 
        List<Room> data = new ArrayList<Room>(); 
  
        // Print all combination using temprary array 'data[]' 
        combinationUtil(arr, n, r, 0, data, 0); 
    } 
}
