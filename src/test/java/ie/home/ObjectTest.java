package ie.home;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ie.home.objects.ObjectExamples;

public class ObjectTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ObjectExamples oe = new ObjectExamples();
		
		oe.checkEquals();
	}

}
