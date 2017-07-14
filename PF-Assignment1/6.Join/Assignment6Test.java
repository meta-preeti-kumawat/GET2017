import static org.junit.Assert.*;

import org.junit.Test;

public class Assignment6Test {
	Assignment6 assignment6 = new Assignment6();
	
	@Test
	  public void joinTest1() {
		//for array with same size
		
		int a[]={2,4,6,8};
		int asize = 4;
		int b[]={1,2,3,15};
		int bsize = 4;
		int[] c = new int[asize+bsize];
		int output[] = assignment6.join(a, asize, b, bsize, c);
		int expectedOutput[] = {1,2,2,3,4,6,8,15};
		assertArrayEquals(expectedOutput, output);
	  }
	
	@Test
	  public void joinTest2() {
		//a is smaller than b
		
		int a[]={2,4,6,8};
		int asize = 4;
		int b[]={1,2,3,15,17};
		int bsize = 5;
		int[] c = new int[asize+bsize];
		int output[] = assignment6.join(a, asize, b, bsize, c);
		int expectedOutput[] = {1,2,2,3,4,6,8,15,17};
		assertArrayEquals(expectedOutput, output);
	  }

	@Test
	  public void joinTest3() {
		//a is larger than b
		
		int a[]={2,4,6,8,10,12};
		int asize = 6;
		int b[]={1,2,3,15};
		int bsize = 4;
		int[] c = new int[asize+bsize];
		int output[] = assignment6.join(a, asize, b, bsize, c);
		int expectedOutput[] = {1,2,2,3,4,6,8,10,12,15};
		assertArrayEquals(expectedOutput, output);
	  }

	@Test
	  public void joinTest4() {
		//unsorted array
		
		int a[]={2,4,6,8};
		int asize = 4;
		int b[]={1,2,3,15,7};
		int bsize = 5;
		int[] c = new int[asize+bsize];
		int output[] = assignment6.join(a, asize, b, bsize, c);
		int[] expectedOutput = new int[asize+bsize];
		assertArrayEquals(expectedOutput, output);
	  }
}