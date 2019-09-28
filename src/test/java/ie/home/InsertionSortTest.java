package ie.home;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ie.home.sorting.InsertionSort;

public class InsertionSortTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int[] arr = {9,3,8,5,10};
		System.out.println("before sort");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		InsertionSort.sort(arr);
		
		System.out.println("after sort");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
	}

}
