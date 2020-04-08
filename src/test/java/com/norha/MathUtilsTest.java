package com.norha;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MathUtilsTest {
	
	/*
	 * @Test will marks a method as a test
	 * 
	 * and informs the junit engin what methods need to run
	 */
	
	
	/*
	 * Expectation vs reality
	 * 
	 * # create an instance of the class under test
	 * 
	 * # Set up inputs
	 * 
	 * # Execute the code you want to test
	 * 
	 * # verify the result is what you expect
	 */
	
	/*
	 * assertEquals
	 * 
	 * assertEquals(expected, actual)
	 * 
	 * 
	 * assertArrayEquals(expectedArray, actualArray)
	 * 
	 * 
	 * assertIterableEquals(expectedArray, actualArray)
	 */
		
	/*
	 * Test Life Cycle
	 * 
	 * Process in which the test instance are created, managed, and distroied
	 * 
	 * JUnit manage the lif cycle of test calss instances.
	 * 
	 * JUnit Provide As some Hooks to exicute code in certain point of Life cycle
	 * 
	 * 1 .suppose there is three methods for test then the method run is random
	 * order
	 * 
	 * 2 . every test method run indipented instance it crates
	 * 
	 * 3. common trap is creates the state outside the method which is irrelevent in
	 * the case of juint5
	 * 
	 * 4 Hooks we have in the Junit Life Cycle they are
	 * 
	 * 1. Inititlaze before anything in the class 2. Tear down after all method are
	 * done
	 * 
	 * 3. Initialization before each method 4. Tear Down after Each Method.
	 * 
	 * 
	 * @BeforeAll
	 * 
	 * @AfterAll
	 * 
	 * @BeforeEach
	 * 
	 * @AfterEach
	 * 
	 * 
	 */
		
	MathUtils mathUtils;
	
	@BeforeEach
	void init() {
		mathUtils = new MathUtils();
	}
	
	@Test
	void testAdd() {
		MathUtils mathUtils = new MathUtils();
		int expected = 2;
		int actual = mathUtils.add(1, 1);
		assertEquals(expected, actual,"Add Method Should add two Numbers");
	}

	/*
	 * try {}catch thing is done by assertThrows
	 * 
	 */
	@Test
	void testDivide() {
		MathUtils mathUtils = new MathUtils();
		assertThrows(NullPointerException.class,() -> mathUtils.divide(1, 0),"Divide by Zero Should Thorw");
	}
	
	@Test
	void testComputeCircleArea() {
		MathUtils mathUtils = new MathUtils();
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10),"It sholud return the right Value");
	}
	

}
