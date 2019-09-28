package ie.home;

import java.util.Arrays;

public class StreamExample {

	public void getMaxFromArray() {
		double[] nums = {0.5,6.3,1.4};
		
		double max = Arrays.stream(nums).max().getAsDouble();
		
		System.out.println(max);
	}
}
