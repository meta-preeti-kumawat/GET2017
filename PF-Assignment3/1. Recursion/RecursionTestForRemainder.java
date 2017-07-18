import java.util.Arrays;
import java.util.Collection;
 

import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RecursionTestForRemainder {
		private int input1;
		private int input2;
		private int expectedResult;
		private Recursion recursion;
		
		@Before
		   public void initialize() {
			recursion = new Recursion();
		   }
		
		public RecursionTestForRemainder(int input1, int input2, int expectedResult) {
			this.input1 = input1;
			this.input2 = input2;
			this.expectedResult = expectedResult;
		}
		
		@Parameterized.Parameters
		   public static Collection<Object[]> inputNumbersForRemainder() {
		      return Arrays.asList(new Object[][] {
		         { 2, 1, 0 },
		         { 2, 0, -1 },
		         { 100, 3, 1 }
		      });
		   }
		
		@Test
		public void testRemainder(){
			System.out.println("Inputs are: "+input1+" and "+input2);
			assertEquals(expectedResult, recursion.rem(input1, input2));
		}
		
}
