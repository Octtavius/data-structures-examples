package ie.home.streams;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ie.home.StreamExample;

public class StreamTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void test() {
		StreamExample se = new StreamExample();
		
		se.getMaxFromArray();
	}

	@Test
	public void test1() {
		
		
//		String[] names = {"Sam", "Pamela", "Dave", "Pascal", "Erik"};
//		IntStream.range(0, names.length)
////		         .filter(i -> names[i].length() <= i)
//		         .mapToObj(i -> names[i])
//		         .collect(Collectors.toList())
//		         .forEach(name -> System.out.println("***" + name));
//		 
	}
}
