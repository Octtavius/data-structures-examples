package ie.home;

import java.util.LinkedList;
import java.util.ListIterator;

import ie.home.data.Apple;

public class ArrayListExample {

	public static void example() {
		LinkedList<Apple> apples = new LinkedList<Apple>();
		Apple a1 = new Apple("Granny Smyth");
		Apple a2 = new Apple("Pink Lady");
		
		apples.add(a1);
		apples.add(a2);
		
		Apple a3 = new Apple("Golden");
		apples.addFirst(a3);
		
//		System.out.println(apples.getFirst().getName());
//		System.out.println(apples.getLast().getName());
		
		ListIterator<Apple> iterator = apples.listIterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getName());
		}
	}
}
