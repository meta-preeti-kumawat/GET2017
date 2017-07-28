import static org.junit.Assert.*;
import matrix.Matrix;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Preeti Kumawat
 * Class Name: MatrixTest
 * Date: 27-07-2017
 *
 */

public class MatrixTest {
    private Matrix matrix;
    private Matrix expectedTranspose;
    private Matrix expectedMultiplication;
    
    @Before
    public void initiate(){
        matrix = new Matrix(1, 2);
        matrix.addElement(0, 0, 1);
        matrix.addElement(0, 1, 2);
        
        expectedTranspose = new Matrix(2, 1);
        expectedTranspose.addElement(0, 0, 1);
        expectedTranspose.addElement(1, 0, 2);
        
        expectedMultiplication = new Matrix(1, 1);
        expectedMultiplication.addElement(0, 0, 5);
    }
    
    @Test
    public void testTranspose(){
        assertArrayEquals("Transposed matrix and expected matrix should be same", expectedTranspose.getData(), matrix.transpose().getData()); 
    }
    
    @Test 
    public void testGetMultiplication(){
        try{
            Matrix result = matrix.getMutliplication(expectedTranspose);
            assertArrayEquals("Resultant matrix and expected matrix for multiplication should be same", 
                               expectedMultiplication.getData(), result.getData()); 
        }
        catch(Exception attributeMismatch){
            
        }
    }
    
    @Test (expected = Exception.class)
    public void testGetMultiplicationForWrongAttributes() throws Exception{
            Matrix result = matrix.getMutliplication(matrix);
            assertNull("For Attributes mismatch exception, Null matrix should be returned", result.getData()); 
        
    }

    @Test
    public void testAddElement(){
        matrix.addElement(0, 1, 3);
        assertEquals("An element 3 should be inserted at index (0,1)", "1 3 \n", matrix.show()); 
    }

    @Test 
    public void testAddElementForNegativeRow(){
        matrix.addElement(-1, 1, 3);
        assertEquals("No undation should take place", "1 2 \n", matrix.show()); 
    }
}
