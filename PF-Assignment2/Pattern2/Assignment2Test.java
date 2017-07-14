import static org.junit.Assert.*;

import org.junit.Test;

public class Assignment2Test {
	Assignment2 assignment2= new Assignment2();
	
	@Test
	  public void spaceTest() {
		//check spaces
		
		String space = assignment2.spaces(1,5);
		assertEquals("", space);
	  }
	
	@Test
	  public void numberTest() {
		//check numbers
		
		String number = assignment2.numbers(1,5);
		assertEquals("12345", number);
	  }
	
	@Test
	  public void patternRowTest() {
		//check row
		
		String pattern[] = assignment2.pyramid(5);
		assertEquals(" 1234", pattern[1]);
	  }

	@Test
	  public void patternTest() {
		//check pattern
		
		String pattern[] = assignment2.pyramid(5);
		String[] expectedPattern = {"12345"," 1234","  123","   12","    1"};
		assertArrayEquals(expectedPattern, pattern);
	  }
}
