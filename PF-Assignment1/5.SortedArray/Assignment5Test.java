import static org.junit.Assert.*;

import org.junit.Test;

public class Assignment5Test {
	Assignment5 assignment5 = new Assignment5();
	
	@Test
	  public void checkSortedArrayTest1() {
		int input[] = {1,2,5,2,5,4,5,5,4,2,2,5,4,5,6,7,8,1,2,4,5,6,7,8,9};
		int output = assignment5.checkSortedArray(input);
	    assertEquals(0, output);
		System.out.print("Test 1: ");
	    assignment5.printOutput(output);
	  }
	
	@Test
	  public void checkSortedArrayTest2() {
		//same values
		int input[] = {1,1,1,1,1,1};
		int output = assignment5.checkSortedArray(input);
		assertEquals(1, output);
		System.out.print("Test 2: ");
	    assignment5.printOutput(output);
	  }

	@Test
	  public void checkSortedArrayTest3() {
		//ascending values
		int input[] = {4,5,6,7,8,9};
		int output = assignment5.checkSortedArray(input);
		assertEquals(1, output);
		System.out.print("Test 3: ");
	    assignment5.printOutput(output);
	  }

	@Test
	  public void checkSortedArrayTest4() {
		//descending values
		int input[] = {10,-1,-2,-4,-7,-20};
		int output = assignment5.checkSortedArray(input);
		assertEquals(2, output);
		System.out.print("Test 4: ");
	    assignment5.printOutput(output);
	  }
}