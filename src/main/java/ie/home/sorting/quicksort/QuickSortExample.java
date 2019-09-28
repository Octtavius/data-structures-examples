package ie.home.sorting.quicksort;

import java.util.Arrays;

public class QuickSortExample {
	public static void main(String[] args) {
		// This is unsorted array
	    int[] array = { 12, 13, 24, 10, 3, 6, 90, 70 };

	    QuickSort qs = new QuickSort();
	    
	    // Let's sort using quick sort
	    qs.quickSort( array, 0, array.length - 1 );

	    // Verify sorted array
	    System.out.println(Arrays.toString(array));
	}
}
