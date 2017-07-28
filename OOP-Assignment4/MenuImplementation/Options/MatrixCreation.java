package Options;

import java.util.InputMismatchException;
import java.util.Scanner;

import matrix.Matrix;
import menu.Action;

public class MatrixCreation implements Action{
    public static Matrix matrix;
    Scanner scanner = new Scanner(System.in);
    
    @Override
    public void performAction() {
        try{
            System.out.print("Enter number of rows: ");
            int rows = scanner.nextInt();
            System.out.print("Enter number of columns: ");
            int columns = scanner.nextInt();
            
            matrix = new Matrix(rows, columns);
            
            System.out.println("Enter values: ");
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    System.out.print("("+row+","+column+") :");
                    int value = scanner.nextInt();
                    matrix.addElement(row, column, value);
                }
            }
        }
        catch(InputMismatchException wrongInput){
            System.out.println("Enter Proper Input");
            scanner.next();
        }
        catch(IndexOutOfBoundsException indexOutOfBound){
            System.out.println(indexOutOfBound.getMessage());
        }
        catch (NegativeArraySizeException negativeArraySize) {
            System.out.println(negativeArraySize.getMessage());
        }
        catch(Exception e){
            System.out.println("Something Went Wrong");
        }
    }
    
    public static Matrix getMatrix(){
        return matrix;
    }

}
