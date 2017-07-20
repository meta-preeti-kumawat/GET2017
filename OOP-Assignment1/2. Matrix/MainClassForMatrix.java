import java.util.Scanner;

public class MainClassForMatrix {
	public static void main(String[] args) {

		Scanner scanInput = new Scanner(System.in);
		
		//scan number of rows and columns in a matrix
		System.out.println("Enter number of rows in Matrix A:");
		int rows = scanInput.nextInt();
		System.out.println("Enter number of columns in Matrix A:");
		int columns = scanInput.nextInt();

		Matrix matrix = new Matrix(rows, columns);

		//scan all the elements of the matrix
		System.out.println("Enter " + (rows * columns) + " values:");
		for (int row = 0; row < rows; row++) {
			System.out.println("Row " + row);
			for (int column = 0; column < columns; column++) {
				System.out.print("Element (" + row + ", " + column + ")");
				int value = scanInput.nextInt();
				matrix.addElement(row, column, value);
			}
		}

		System.out.println("Matrix is: ");
		System.out.println(matrix.show()); // display matrix
		
		//transpose the matrix
		Matrix transpose = matrix.transpose();
		System.out.println("Transposed Matrix is: ");
		System.out.println(transpose.show());

		try {
			//multiply matrix with its transpose
			System.out.println("Result of A * transpose of A");
			Matrix multiplicationResult = matrix.getMutliplication(transpose);
			System.out.println(multiplicationResult.show());
			
			//multiply matrix with itself
			System.out.println("Result of A * A");
			Matrix multiplicationResultException = matrix.getMutliplication(matrix);
			System.out.println(multiplicationResultException.show());
		} 
		catch (Exception attributesMismatch) {
			System.out.println(attributesMismatch.getMessage());
		}
		
		scanInput.close();

	}
}
