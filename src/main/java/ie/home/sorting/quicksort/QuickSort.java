package ie.home.sorting.quicksort;

public class QuickSort {

	public void quickSort(int[] array, int leftIndex, int rightIndex) {
		// if array is empty do nothing
		if (array.length == 0) {
			return;
		}
		
		// if left index and right index pass by eachother, then return
		if (leftIndex >= rightIndex) {
			return;
		}
		
		// get the pivot from the middle of the array
		int middle = leftIndex + (rightIndex - leftIndex) / 2;
		int pivot = array[middle];
		
		// create temp indexes for left and right indexes
		int i = leftIndex, j = rightIndex;
		
		while(i <= j) {
			// move the left index to the right until 
			// all values to the left are smaller than the pivot
			while (array[i] < pivot) {
				i++;
			}
			
			// move the right index to the left until 
			// all values to the right are greater than the pivot
			while (array[j] > pivot) {
				j--;
			}
			
			//Now compare values from both side of lists to see if they need swapping
            //After swapping move the iterator on both lists
			if (i <= j) {
				swap(array, i, j);
				// move indexes to next position on both sides
				i++;
				j--;
			}
			
			//Do same operation as above recursively to sort two sub arrays
			if (leftIndex < j) {
				quickSort(array, leftIndex, j);
			}
			
			if (rightIndex > i) {
				quickSort(array, i, rightIndex);
			}
		}
	}

	private void swap(int[] array, int x, int y) {
		int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
		
	}
}
