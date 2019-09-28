package ie.home.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ie.home.Room;

public class ListExample {
	static int count = 0;
	public void listSplit() {
		ArrayList<String> listOne = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "f"));
        
        ArrayList<String> listTwo = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e"));
         
        Collections.sort(listOne);
        Collections.sort(listTwo);
         
        //Compare unequal lists example
         
        boolean isEqual = listOne.equals(listTwo);      //false
        System.out.println(isEqual);
         
        //Compare equals lists example
         
        ArrayList<String> listThree = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "f"));
         
        isEqual = listOne.equals(listThree);      //true
        System.out.println(isEqual);
        
        List<List<String>> manyLists = new ArrayList<List<String>>();
        manyLists.add(listOne);
        manyLists.add(listTwo);
        System.out.println(manyLists.contains(listThree));
        
		Room r4 = new Room(60961872, "TWINTRIPLE", "2019-04-01", "2019-04-08", 2, 3, 70, "pp");
		Room r1 = new Room(60961869, "DOUBLE", "2019-04-01", "2019-04-08", 2, 2, 120, "pp");
		Room r2 = new Room(60961870, "DOUBLE", "2019-04-01", "2019-04-08", 2, 2, 120, "pp");
		Room r3 = new Room(60961871, "TWIN", "2019-04-01", "2019-04-08", 1, 2, 95, "pp");
		Room r5 = new Room(60961873, "TWIN", "2019-04-01", "2019-04-08", 1, 2, 95, "pp");
		
		List<Room> combination = new ArrayList<Room>();
//		combination.add(r1);
		combination.add(r2);
		combination.add(r3);
		combination.add(r4);
		combination.add(r5);

        System.out.print("The combinations are: ");
        printCombinations(combination, combination.size());
        
        
	}
	
	static void printCombinations(List<Room> rooms, int N) 
    {
        Room[] combinations = new Room[N];
        for (int r = 0; r < rooms.size(); r++) {        	
        	combinations(rooms, combinations, 0, N - 1, 0, r);
        }
        System.out.println(count);
    }
	
	
	
	static void combinations(List<Room> rooms, Room[] combinations, int start, int end,
            int index, int r) 
    {
		count++;
		List<Room> tempComb= Arrays.asList(combinations);
 
		int guests = 7;
		int maxGuestsCap = 0;
		int minGuestsCap = 0;
		int price = 0;
		
		if(count == 57) {
			System.out.println("");
		}
		
        if (index == r) 
        {
        	int currentPrice = -1;
        	System.out.println("+++++++++++++++++++++++++++++++++");
        	double smallestPrice = -1;
            for (int j = 0; j < r; j++) {
            	
            	maxGuestsCap += tempComb.get(j).getMaxGuests();
            	minGuestsCap += tempComb.get(j).getMinGuests();
            	System.out.println(tempComb.get(j).getPrice() + " " + " " + tempComb.get(j).getMinGuests() + "  " + tempComb.get(j).getMaxGuests()
            			+ "   pp: " + tempComb.get(j).getPrice());
            	price += tempComb.get(j).getPrice() * tempComb.get(j).getMinGuests();
            }
            
//            while (tempComb.remove(null));
            
            if (guests > minGuestsCap) {
            	List<Room> newList = tempComb.stream()
    					.filter(x -> x != null)	// or Objects::nonNull
    					.collect(Collectors.toList());

            	newList.sort(
            		      (Room h1, Room h2) -> Double.compare(h1.getPrice(), h2.getPrice()));
            	int currentCap = minGuestsCap;
            	for (Room room : newList) {
					if (currentCap < guests) {
						int spaceAvailableInRoom = room.getMaxGuests() - room.getMinGuests();
						if (spaceAvailableInRoom > 0) {
							price += room.getPrice() * spaceAvailableInRoom;
							currentCap += spaceAvailableInRoom;
						}
					}
				}
            	System.out.println();
            }
            
            System.out.println("   " + price);
            System.out.println("min guests: "  + minGuestsCap);
            System.out.println("max guests: "  + maxGuestsCap);
            System.out.println("+++++++++++++++++++++++++++++++++");
            System.out.println();
        }
 
        for (int i = start; i <= end && ((end - i + 1) >= (r - index)); i++) 
        {
        	tempComb.set(index, rooms.get(i));
            combinations(rooms, combinations, i + 1, end, index + 1, r);
        }
    }
	
	public static void removeIterating() {
		Map<Integer, List<Integer>> nums = new HashMap<Integer, List<Integer>>();
		List<Integer> al = new ArrayList<>(); 
        al.add(10); 
        al.add(20); 
        al.add(30); 
        al.add(1); 
        al.add(2); 
        List<Integer> al1 = new ArrayList<>(); 
        al1.add(50); 
        al1.add(60); 
        al1.add(40); 
        al1.add(9); 
        al1.add(7); 
  
        nums.put(1, al);
        nums.put(2, al1);
        
        for (Integer n: nums.keySet()) {
        	
        	// Remove elements smaller than 10 using 
        	// Iterator.remove() 
        	Iterator itr = nums.get(n).iterator(); 
        	while (itr.hasNext()) 
        	{ 
        		int x = (Integer)itr.next(); 
        		if (x < 10) 
        			itr.remove(); 
        	} 
        	
        	System.out.println("Modified ArrayList : "
        			+ nums.get(n)); 
        }
        
	}
}
