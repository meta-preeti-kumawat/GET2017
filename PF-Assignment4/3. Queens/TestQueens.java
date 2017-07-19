import static org.junit.Assert.*;

import java.util.InputMismatchException;

import org.junit.Test;

/**
 * @author Preeti Kumawat
 * Class Name: TestQueens
 * Date: 19-07-2017
 *
 */
public class TestQueens {
	private Queens queens;

	@Test (expected = NegativeArraySizeException.class)
	public void testQueensForNegative(){
		queens = new Queens(-1);
		short[][] positionOfQueens = queens.callPlaceNQueens();
		assertNull("Should Be Null",positionOfQueens);
	}
	
	@Test (expected = InputMismatchException.class)
	public void testQueensForCharacter(){
		queens = new Queens('a');
		short[][] positionOfQueens = queens.callPlaceNQueens();
		assertNull("Should Be Null",positionOfQueens);
	}
	
	
	@Test
	public void testQueensForThree(){
		queens = new Queens(3);
		short[][] positionOfQueens = queens.callPlaceNQueens();
		assertNull("Should Be Null",positionOfQueens);
	}

	@Test
	public void testQueensForFour(){
		queens = new Queens(4);
		short[][] positionOfQueens = queens.callPlaceNQueens();
		assertNotNull("Should Not Be Null",positionOfQueens);
	}

	@Test
	public void testQueensForEight(){
		queens = new Queens(8);
		short[][] positionOfQueens = queens.callPlaceNQueens();
		assertNotNull("Should Not Be Null",positionOfQueens);
	}
}
