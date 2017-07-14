import static org.junit.Assert.*;

import org.junit.Test;

public class Assignment1Test {
	Assignment1 assignment1= new Assignment1();
	
	@Test
	  public void spaceTest() {
		//check spaces
		
		String space = assignment1.spaces(6,5);
		assertEquals(" ", space);
	  }
	
	@Test
	  public void numberTest() {
		//check numbers
		
		String number = assignment1.numbers(6,5);
		assertEquals("1234321", number);
	  }

	@Test
	  public void exceededRowNumberTest() {
		//when number of rows passed are greater than actual value
		
		String number = assignment1.numbers(10,5);
		assertEquals("", number);
	  }
	
	@Test
	  public void patternRowTest() {
		//check row
		
		String pattern[] = assignment1.pyramid(5);
		assertEquals("    1    ", pattern[0]);
	  }

	@Test
	  public void patternTest() {
		//check pattern
		
		String pattern[] = assignment1.pyramid(2);
		String[] expectedPattern = {" 1 ","121"," 1 "};
		assertArrayEquals(expectedPattern, pattern);
	  }
}
