package ie.home.sorting.merge;

import java.util.Arrays;

public class MergeSort {
	
	public static void mergeSort(int[] arr, int arrayLength) {
		// if array is only 1 element then return. you don't have anything to split or sort
		if (arrayLength < 2) {
			return;
		}
		
		//find mid of array
		int mid = arrayLength / 2;
		
		// if arr = 7 elements. then length/2 = 3. Thus left array will have 3 elements,
		//right array will have 7 - 3 = 4
		int[] leftSubArray = Arrays.copyOfRange(arr, 0, mid);
		int[] rightSubArray = Arrays.copyOfRange(arr, mid, arrayLength);
		
		mergeSort(leftSubArray, mid);
		mergeSort(rightSubArray, arrayLength - mid);
		
		merge(arr, leftSubArray, rightSubArray);
	}

	public static void merge (int[] result, int[] leftSubArray, 
			int[] rightSubArray) {
		//Index Position in Left array - starting with first element
        int indexInLeft = 0;
         
        //Index Position in right array - starting with first element
        int indexInRight = 0;
         
        //Index Position in merged array - starting with first position
        int indexInMerged = 0;
        
      //Compare elements at iFirst and iSecond,
        //and move smaller element at iMerged
        while (indexInLeft < leftSubArray.length && indexInRight < rightSubArray.length) {
        	if (leftSubArray[indexInLeft] < rightSubArray[indexInRight]) {
        		result[indexInMerged] = leftSubArray[indexInLeft];
        		indexInLeft++;
        	} else {
        		result[indexInMerged] = rightSubArray[indexInRight];
        		indexInRight++;
        	}
        	
        	indexInMerged++;
        }
        
        System.arraycopy(leftSubArray, indexInLeft, result, indexInMerged, leftSubArray.length - indexInLeft);
        System.arraycopy(rightSubArray, indexInRight, result, indexInMerged, rightSubArray.length - indexInRight);
	}
}
