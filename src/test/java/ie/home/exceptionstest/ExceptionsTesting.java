package ie.home.exceptionstest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ie.home.exceptions.ExceptionThrower;

public class ExceptionsTesting {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ExceptionThrower.nestedExceptions();
	}

}
