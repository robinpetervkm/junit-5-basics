package com.norha;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
