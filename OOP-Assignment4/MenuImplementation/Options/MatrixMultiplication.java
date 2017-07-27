package Options;

import matrix.Matrix;
import menu.Action;

public class MatrixMultiplication implements Action{
    private static Matrix matrix;
    @Override
    public void performAction() {
        //check for null matrix
        if( MatrixCreation.getMatrix() == null){
            System.out.println("Original matrix and transposed matrix are not available");
        }
        else if( MatrixTranspose.getMatrix() == null){
            System.out.println("Transposed matrix not available");
        }
        else{
            try {
                matrix = MatrixCreation.getMatrix().getMutliplication(MatrixTranspose.getMatrix());
                System.out.println(matrix.show());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static Matrix getMatrix(){
        return MatrixMultiplication.matrix;
    }
}
