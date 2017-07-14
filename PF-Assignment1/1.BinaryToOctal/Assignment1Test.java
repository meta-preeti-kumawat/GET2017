import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Assignment1Test {
	Assignment1 obj = new Assignment1();
	
	@Test
	  public void evalutesBinary() {
		//for binary values
		
		int octal = obj.convertBinaryToOctal(110101);
	    assertEquals(65, octal);
	    
	  }
	
	@Test
	  public void evaluatesNonBinary() {
		//for non binary values
		
		int octal = obj.convertBinaryToOctal(123);
		assertEquals("Not a Binary Number", -1, octal);
	  }
}
