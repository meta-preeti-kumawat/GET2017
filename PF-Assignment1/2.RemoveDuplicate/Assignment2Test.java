import static org.junit.Assert.*;

import org.junit.Test;

public class Assignment2Test {
	Assignment2 obj = new Assignment2();
	
	@Test
	  public void removeDuplicateTest1() {
		int input[] = {2,5,4,6,3,8,5,9,3,3,6,3,9,0};
		int[] output = obj.removeDuplicate(input);
		int[] expectedOutput = {2,5,4,6,3,8,9,0};
	    assertArrayEquals(expectedOutput, output); 
	  }
	
	@Test
	  public void removeDuplicateTest2() {
		//for same values in array
		
		int input[] = {1,1,1,1,1,1};
		int[] output = obj.removeDuplicate(input);
		int[] expectedOutput = {1};
	    assertArrayEquals(expectedOutput, output);
	  }

	@Test
	  public void removeDuplicateTest3() {
		//for distinct values in array
		
		int input[] = {1,2,3,4,5,6,7,8,9,0};
		int[] output = obj.removeDuplicate(input);
		int[] expectedOutput = {1,2,3,4,5,6,7,8,9,0};
	    assertArrayEquals(expectedOutput, output);
	  }

	@Test
	  public void removeDuplicateTest4() {
		//for negative values 
		
		int input[] = {-1,2,3,-4,5,6,7,-1};
		int[] output = obj.removeDuplicate(input);
		int[] expectedOutput = {-1,2,3,-4,5,6,7};
	    assertArrayEquals(expectedOutput, output);
	  }
}