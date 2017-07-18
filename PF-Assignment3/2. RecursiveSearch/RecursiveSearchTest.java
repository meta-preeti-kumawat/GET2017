import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class RecursiveSearchTest {
		private RecursiveSearch recursiveSearch;
		
		@Before
		   public void initialize() {
			recursiveSearch = new RecursiveSearch();
		   }
				
		@Test
		public void testLinearSearchElementNotPresent(){
			//Element not present
			int[] inputArray = {2,5,8,9,10,77,55};
			int searchElement = 88;
	
			assertFalse(recursiveSearch.linearSearch(inputArray, 0, searchElement));
		}
	
		@Test
		public void testLinearSearchElementPresent(){
			//Element Present
			int[] inputArray = {2,5,8,9,10,77,55,11};
			int searchElement = 77;
	
			assertTrue(recursiveSearch.linearSearch(inputArray, 0, searchElement));
		}
		
		@Test
		public void testBinarySearchElementNotPresent(){
			//Element not present
			int[] inputArray = {2,5,8,9,10,77,55};
			int searchElement = 88;
	
			assertFalse(recursiveSearch.linearSearch(inputArray, 0, searchElement));
		}
	
		@Test
		public void testBinarySearchElementPresent(){
			//Element Present
			int[] inputArray = {2,5,8,9,10,77,55};
			int searchElement = 77;
	
			assertTrue(recursiveSearch.linearSearch(inputArray, 0, searchElement));
		}
}
