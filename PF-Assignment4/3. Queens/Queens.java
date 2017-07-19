import java.util.InputMismatchException;

/**
 * 
 * @author Preeti Kumawat
 *  Date: 19-07-2017
 *  Class Name: Queens
 *
 */
public class Queens {
    private int[] queensColumn;
    private int numberOfSolutions = 0;
    private short[][] positionsOfqueens;
    
    public Queens(char wrongInput) {
		throw new InputMismatchException();	
    }
    
    /**
     * @param numberOfQueens 
     */
    public Queens(int numberOfQueens) {
    	try{
			queensColumn = new int[numberOfQueens];	
    	}
    	catch(NullPointerException e){
    		//do nothing
    	}
    	
    }
    
    /**
     * @param queensColumn int[]
     * This method helps to print Position of Queens
     */
    public void printQueens(int[] queensColumn){
    	int length = queensColumn.length;
    	positionsOfqueens = new short[length][length];
    	for(int row = 0; row < length; row++){
    		for(int column = 0; column < length; column++){
    			if(queensColumn[row] == column){
    				System.out.print(" 1");
    				positionsOfqueens[row][column] = 1;
    			}
    			else{
    				System.out.print(" 0");
    				positionsOfqueens[row][column] = 0;
    			}
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
    
    /**
     * @param rowOfCurrentQueen
     * @param columnOfCurrentQueen
     * @return Boolean flag
     */
    public Boolean canPlaceQueen(int rowOfCurrentQueen, int columnOfCurrentQueen) {
	Boolean flag = true;
    	// Returns True is Queen can be placed at current row and column
    	for(int loop = 0; loop < rowOfCurrentQueen; loop++){
    		if( queensColumn[loop] == columnOfCurrentQueen 
    				|| (loop - rowOfCurrentQueen) == (queensColumn[loop] - columnOfCurrentQueen) 
    				|| (loop - rowOfCurrentQueen) == (columnOfCurrentQueen - queensColumn[loop])){
    			flag = false;
    			break;
    		}
    	}
    	return flag;
	}
    
    /**
     * @param rowOfCurrentQueen int
     * @param numberOfQueens int
     */
    public void placeNQueens(int rowOfCurrentQueen, int numberOfQueens) { 
        /*
         * This loop finds the correct position of a Queen in a row 
         * such that no Queen attack each other  
         */
        for(int column = 0; column < numberOfQueens; column++){
            if(canPlaceQueen(rowOfCurrentQueen, column)){
                queensColumn[rowOfCurrentQueen] = column;
                if(rowOfCurrentQueen == numberOfQueens - 1){
                    System.out.println("Solution "+ ++numberOfSolutions);
                	printQueens(queensColumn);
                	return;
                }
                else{
                    placeNQueens(rowOfCurrentQueen + 1, numberOfQueens);
                }
            }
        }
    }
    
    /**
     * used to call placeNQueens method for the first time
     */
    public short[][] callPlaceNQueens(){
    	try{
    		placeNQueens(0, queensColumn.length);   
    	}
    	catch(NullPointerException e){
    	}
    	return positionsOfqueens;
        
    }
}
