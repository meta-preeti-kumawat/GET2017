package Options;

import matrix.Matrix;
import menu.Action;

public class MatrixTranspose implements Action{
    private static Matrix matrix;
    
    @Override
    public void performAction() {
        //check for null matrix
        if(MatrixCreation.getMatrix() != null){
            MatrixTranspose.matrix = MatrixCreation.getMatrix().transpose();
            System.out.println(matrix.show());
        }
        else{
            System.out.println("Please enter a matrix to be transposed");
        }
    }
    
    public static Matrix getMatrix(){
        return MatrixTranspose.matrix;
    }
}
