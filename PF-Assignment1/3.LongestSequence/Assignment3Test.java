import static org.junit.Assert.*;

import org.junit.Test;

public class Assignment3Test {
	Assignment3 assignment3 = new Assignment3();
	
	@Test
	  public void longestSequenceTest1() {
		int input[] = {1,2,3,2,3,4,5,3,4,2,2,3,4,5,6,7,8,1,2,4,5,6,7,8,9};
		int[] output = assignment3.longestSequence(input);
		int[] expectedOutput = {1,2,4,5,6,7,8,9};
	    assertArrayEquals(expectedOutput, output); 
	  }
	
	@Test
	  public void longestSequenceTest2() {
		//same values in array
		
		int input[] = {1,1,1,1,1,1};
		int[] output = assignment3.longestSequence(input);
		int[] expectedOutput = {1};
	    assertArrayEquals(expectedOutput, output);
	  }

	@Test
	  public void longestSequenceTest3() {
		//distinct values in array
		
		int input[] = {1,2,3,4,5,6,7,8,9,0};
		int[] output = assignment3.longestSequence(input);
		int[] expectedOutput = {1,2,3,4,5,6,7,8,9};
	    assertArrayEquals(expectedOutput, output);
	  }

	@Test
	  public void longestSequenceTest4() {
		//for negative values
		
		int input[] = {-1,2,3,-4,5,6,7,-1};
		int[] output = assignment3.longestSequence(input);
		int[] expectedOutput = {-4,5,6,7};
	    assertArrayEquals(expectedOutput, output);
	  }
}