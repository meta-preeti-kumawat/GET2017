/**
 * 
 * @author Preeti Kumawat
 * Date: 19-07-2017
 * Class Name: Matrix
 *
 */
public class Matrix {
    private int data[][];
    private int numberOfRows;
    private int numberOfColumns;
    
    /**
     * @param numberOfRows int
     * @param numberOfColumns int
     */
    public Matrix(int numberOfRows, int numberOfColumns) {
        try{
        	this.numberOfRows = numberOfRows;
            this.numberOfColumns = numberOfColumns;
            this.data = new int[numberOfRows][numberOfColumns];
        }
        catch(Exception negativeIndex){}
    }
    
    /**
     * @param row
     * @param column
     * @param value
     * Used to insert a new value at given row and column
     */
    public void addElement(int row, int column, int value){
        try{
            data[row][column] = value;
        }
        catch(IndexOutOfBoundsException indexOutOfBound){}
    }
    
    /**
     * @return data[][]
     */
    public int[][] getData(){
    	return data;
    }
    
    /**
     * @return Matrix transposedMatrix
     */
    public Matrix transpose() {
        Matrix transposedMatrix = new Matrix(numberOfColumns, numberOfRows);
        for(int row = 0; row < numberOfColumns; row++){
            for (int column = 0; column < numberOfRows; column++) {
                transposedMatrix.data[row][column] = this.data[column][row];
            }
        }
        return transposedMatrix;
    }
    
    /**
     * Used to display the content of matrix
     */
    public String show(){
    	String dataString = "";
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                dataString += data[row][column]+" ";
            }
            dataString += "\n";
        }
        return dataString;
    }
    
    /**
     * @param matrixToMultiply
     * @return Matrix multiplicationResult
     * @throws Exception
     */
    public Matrix getMutliplication(Matrix matrixToMultiply) throws Exception  {
    	Matrix multiplicationResult = null;
    	
		if (this.numberOfColumns == matrixToMultiply.numberOfRows) {
			multiplicationResult = new Matrix(this.numberOfRows, matrixToMultiply.numberOfColumns);
			for (int row = 0; row < multiplicationResult.numberOfRows; row++) {
				for (int column = 0; column < multiplicationResult.numberOfColumns; column++) {
					for (int commonAttribute = 0; commonAttribute < this.numberOfColumns; commonAttribute++) {
						multiplicationResult.data[row][column] += this.data[row][commonAttribute]
																  * matrixToMultiply.data[commonAttribute][column];
					}
				}

			}
		} else {
			throw new Exception("Input Matrices are not compatible for multiplication");
		}
        
        return multiplicationResult;
    }
    
   
}
