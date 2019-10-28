package ie.home.combinations;

import java.util.Arrays;

public class PermutationExample {
	static int allData[] = {1, 2, 3, 4, 5, 6};
	static String stringData[] = {"A", "B", "C", "D", "E"};
	static int combinationSize = 3;

	public static void main (String[] args) {
		int currentDataLength = allData.length;
		
		printCombination(currentDataLength);
		
		 
	}
	
	// The main function that prints all combinations of size r 
    // in arr[] of size n. This function mainly uses combinationUtil() 
    static void printCombination(int currentDataLength) 
    { 
        // A temporary array to store all combination one by one 
        int combination[]=new int[combinationSize]; 
  
        // Print all combination using temprary array 'data[]' 
        combinationUtil(combination, 0, currentDataLength-1, 0); 
    } 
    
    
    /* arr[]  ---> Input Array 
    data[] ---> Temporary array to store current combination 
    start & end ---> Staring and Ending indexes in arr[] 
    index  ---> Current index in data[] 
    r ---> Size of a combination to be printed */
    static void combinationUtil(int combination[], int startIndex, 
                                int endIndex, int currentIndex) 
    { 
        // Current combination is ready to be printed, print it 
        if (currentIndex == combinationSize) 
        { 
            for (int j=0; j<combinationSize; j++) 
                System.out.print(combination[j]+" "); 
            System.out.println(""); 
            return; 
        } 
  
        // replace index with all possible elements. The condition 
        // "end-i+1 >= r-index" makes sure that including one element 
        // at index will make a combination with remaining elements 
        // at remaining positions 
        for (int i=startIndex; i<=endIndex && endIndex-i+1 >= combinationSize-currentIndex; i++) 
        { 
        	combination[currentIndex] = allData[i]; 
            combinationUtil(combination, i+1, endIndex, currentIndex+1); 
        } 
    }
}
