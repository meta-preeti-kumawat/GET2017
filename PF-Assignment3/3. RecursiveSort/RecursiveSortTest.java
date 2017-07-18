import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class RecursiveSortTest {
		private RecursiveSort recursiveSort;
		
		@Before
		   public void initialize() {
			recursiveSort = new RecursiveSort();
		   }
				
		@Test
		public void testQuickSortForUnsortedArray(){
			int[] array = {2,5,8,9,10,77,55,11};
			int[] expected = {2,5,8,9,10,11,55,77};
			
			recursiveSort.quickSort(array, 0, array.length-1);
			assertArrayEquals(expected, array);
			for (int i=0; i< array.length; i++) {
				System.out.println(array[i]);
			}
		}
		
		@Test
		public void testQuickSortForEmptyArray(){
			int[] array = {};
			int[] expected = {};
			
			recursiveSort.quickSort(array, 0, array.length-1);
			assertArrayEquals(expected, array);
		}
		
		@Test
		public void testQuickSortForSortedArray(){
			int[] array = {2,5,8,9,10,11,55,77};
			int[] expected = {2,5,8,9,10,11,55,77};
			
			recursiveSort.quickSort(array, 0, array.length-1);
			assertArrayEquals(expected, array);
			for (int i=0; i< array.length; i++) {
				System.out.println(array[i]);
			}
		}

		@Test
		public void testQuickSortForReverseSortedArray(){
			int[] array = {77,55,11,10,9,8,5,2};
			int[] expected = {2,5,8,9,10,11,55,77};
			
			recursiveSort.quickSort(array, 0, array.length-1);
			assertArrayEquals(expected, array);
			for (int i=0; i< array.length; i++) {
				System.out.println(array[i]);
			}
		}
}
