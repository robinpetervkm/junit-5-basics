package com.norha;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@DisplayName("When Running the MathUtils")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
	
	
	/*
	 * BeforeAll and AfterAll will not run normal methods because it is not depend
	 * on the instance of the test class even before the instance is created
	 * 
	 * so. we have to declear them as static
	 * 
	 */
	
	/*
	 * Calss instance creation can be alterd using annotaion
	 * 
	 * by default it is per
	 * 
	 * @TestInstance(TestInstance.Lifecycle.PER_METHOD) we can make as per class
	 * 
	 * @TestInstance(TestInstance.Lifecycle.PER_CLASS)
	 * 
	 * if use the PER_CLASS then @BeforeAll AND @AfterAll Method not to be Static
	 * 
	 * 
	 */
	
	
	/*
	 * Annotation to Scale your Tests
	 * 
	 * 
	 * @DisplayName
	 * 
	 * @Disabled
	 * 
	 */
	
	/*
	 * 
	 * Conditional Execution
	 * 
	 * @EnabledOnOs(OS.LINUX)
	 * 
	 * @EnabledOnJre(JRE.JAVA_10)
	 * 
	 * @EnabledIf
	 * @EnabledIfEnvironmentVariables
	 * 
	 * @EnabledIfSystemProperty    Dev Node Only
	 * 
	 * 
	 * 
	 * 
	 */
	
	/*
	 * Handling External Factor
	 * 
	 * assumeThat
	 * 
	 * 
	 * assumeTrue (boolean)
	 * this is used when programmatic condition check if the server is down there 
	 * is no point of running the test
	 */
	
	/*
	 * @Nested
	 * 
	 * class
	 * 
	 * will give proper meaning full sentence for the test report
	 */ 
	
	/*
	 * assertAll is a mechaniseam to run a bunch of assert statement in a single
	 * statements
	 */
	
	
	
	
	MathUtils mathUtils;
	
	@AfterAll
	void afterAllCleanup() {
		System.out.println("Last Clean up...");
	}
	
	@BeforeAll
	void beforeAllInit() {
		System.out.println("Berfoe All Called...");
	}
	
	@BeforeEach
	void init() {
		mathUtils = new MathUtils();
	}
	@AfterEach
	void cleanup(){
		System.out.println("Cleaning Up........");
	}
	
	@Nested
	@DisplayName("Subtract Methods")
	class SubtactTest {
		@Test
		@DisplayName("When Subtracting with Positive Numbers")
		void testSubtractPositive() {
			assertEquals(2, mathUtils.subtract(4, 2), "Should return Positive Number ");
		}
		@Test
		@DisplayName("When Subtracting with Negative Numbers")
		void testSubtractNegative() {
			assertEquals(-3, mathUtils.subtract(-8, -5), "Should return Negative Number ");
		}
	}
	
	@Test
	@DisplayName("Multiply Methods")
	void testMultiply() {
		assertAll(
				() -> assertEquals(2, mathUtils.multiply(1, 2)),
				() -> assertEquals(0, mathUtils.multiply(0, 2)),
				() -> assertEquals(-2, mathUtils.multiply(-1, 2))
				);
	}
	
	
	@Test
	@EnabledOnOs(OS.LINUX)
	@DisplayName("TESTING ADD method")
	void testAdd() {
		int expected = 2;
		int actual = mathUtils.add(1, 1);
		assertEquals(expected, actual,"Add Method Should add two Numbers");
	}
	@Test
	@DisplayName("Testing Disabled Annotation")
	@Disabled
	void testDisabled() {
		fail("This Test Should not to Be Run");
	}

	/*
	 * try {}catch thing is done by assertThrows
	 * 
	 */
	@Test
	void testDivide() {
		boolean isServerUp = false;
		assumeTrue(isServerUp);
		assertThrows(ArithmeticException.class,() -> mathUtils.divide(1, 0),"Divide by Zero Should Thorw");
	}
	
	@Test
	@RepeatedTest(3)
	void testComputeCircleArea() {
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10),"It sholud return the right Value");
	}
	

}
