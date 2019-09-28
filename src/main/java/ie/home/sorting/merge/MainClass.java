package ie.home.sorting.merge;

public class MainClass {

	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		
		int[] array = {4, 7, 1, 15,9, 10, 3};
		ms.mergeSort(array, array.length);
		
		for (int i : array) {
			System.out.print(i + ", ");
		}
	}
}
