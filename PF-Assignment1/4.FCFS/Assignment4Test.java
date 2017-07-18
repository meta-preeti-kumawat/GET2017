import static org.junit.Assert.*;

import org.junit.Test;

public class Assignment4Test {
	Assignment4 assignment4 = new Assignment4();
	
	@Test
	  public void FCFSTest1() {
		int[] arrival_time = {5,1,9,25};
		int[] job_size = {7,12,2,5};
		int[][] output = assignment4.FCFS(arrival_time, job_size);
		int expectedOutput[][] = {{2,1,0,1,12},{1,5,8,13,19},{3,9,11,20,21},{4,25,0,25,29}};
		assertArrayEquals(expectedOutput, output);
	  }
	
	
}