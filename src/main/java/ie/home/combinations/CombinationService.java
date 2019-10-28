package ie.home.combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationService {

	private static int combinationSize = 3;
	static List<String> stringData = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E" ));

	public static void combination() {
		int startingIndex = 0;
		int endIndex = stringData.size() - 1;
		int currentIndex = 0;
		String[] combination = new String[combinationSize];
		generateCombination(stringData, 3, "");
	}

	private static void generateCombination(List<String> e, int remainingSlotsInCombinationArr, String accumulated) {
		// 1. stop
		if(e.size() < remainingSlotsInCombinationArr)
			return;
		
		// 2. add each element in e to accumulated
		if(remainingSlotsInCombinationArr == 1)
			for(String s:e)
				print(accumulated+s);
		
		// 3. add all elements in e to accumulated
		else if(e.size() == remainingSlotsInCombinationArr){
			for(String s:e)
				accumulated+=s;
			print(accumulated);
		}
		
		// 4. for each element, call combination
		else if(e.size() > remainingSlotsInCombinationArr)
			for(int i = 0 ; i < e.size() ; i++) {
				
				generateCombination(e.subList(i+1, e.size()), remainingSlotsInCombinationArr-1, accumulated+e.get(i));
			}
	}

	public static void print(String string) {
		System.out.println(string);
	}

	public static void main(String[] args) {
		combination();
	}
}
