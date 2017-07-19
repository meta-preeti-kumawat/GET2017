import java.util.Arrays;
import java.util.Collection;
 


import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RecursionTestForLargestDigit {
		private int input;
		private int expectedResult;
		private Recursion recursion;
		
		@Before
		   public void initialize() {
			recursion = new Recursion();
		   }
		
		public RecursionTestForLargestDigit(int input, int expectedResult) {
			this.input = input;
			this.expectedResult = expectedResult;
		}
		

		@Parameterized.Parameters
		   public static Collection<Object[]> inputNumbersForLargestDigit() {
		      return Arrays.asList(new Object[][] {
		         { 2, 2 },
		         { 1257369, 9 },
		         { 444, 4 }
		      });
		   }
		
		@Test
		public void testLargestDigit(){
			System.out.println("Input is: "+input);
			assertEquals(expectedResult, recursion.largestDigit(input));
		}
		
}
