import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;

import org.junit.Test;
import org.junit.Before;

/**
 * @author Preeti Kumawat
 * Class Name: TestTowerOfHanoi
 * Date: 18-07-2017
 *
 */
public class TestTowerOfHanoi {
	private TowerOfHanoi towerOfHanoi;
	private String source = "A";
	private String destination = "B";
	private String auxiliary = "C";
	
	private ArrayList<String> listOfMovements = new ArrayList<String>();
	private ArrayList<String> expectedListOfMovements = new ArrayList<String>();

	@Before
	   public void initialize() {
		towerOfHanoi = new TowerOfHanoi();
	   }
	
	@Test(expected = InputMismatchException.class)
	public void testTowerOfHanoiForNegativeDisk(){
		int numberOfDisk = -1;
		
		listOfMovements = towerOfHanoi.towerOfHanoi(source, destination, auxiliary, numberOfDisk);
		
		Iterator<String> itr=listOfMovements.iterator();  
		System.out.println("For One Disk");  
		while(itr.hasNext()){  
			System.out.println(itr.next());  
		}  
	  
		assertEquals("ArrayList should be equal",expectedListOfMovements, listOfMovements);
	}
	
	@Test
	public void testTowerOfHanoiForOneDisk(){
		int numberOfDisk = 1;
		
		expectedListOfMovements.add("Move Disk 1 from A to B");
		
		listOfMovements = towerOfHanoi.towerOfHanoi(source, destination, auxiliary, numberOfDisk);
		
		Iterator<String> itr=listOfMovements.iterator();  
		System.out.println("For One Disk");  
		while(itr.hasNext()){  
			System.out.println(itr.next());  
		}  
	  
		assertEquals("ArrayList should be equal",expectedListOfMovements, listOfMovements);
	}
	
	@Test
	public void testTowerOfHanoiForTwoDisks(){
		int numberOfDisk = 2;
		
		expectedListOfMovements.add("Move Disk 1 from A to C");
		expectedListOfMovements.add("Move Disk 2 from A to B");
		expectedListOfMovements.add("Move Disk 1 from C to B");
		
		listOfMovements = towerOfHanoi.towerOfHanoi(source, destination, auxiliary, numberOfDisk);
		
		Iterator<String> itr=listOfMovements.iterator();  
		System.out.println("For Two Disks");  
		while(itr.hasNext()){  
			System.out.println(itr.next());  
		}  
		  
		assertEquals("ArrayList should be equal",expectedListOfMovements, listOfMovements);
	}
	
	@Test
	public void testTowerOfHanoiForThreeDisks(){
		int numberOfDisk = 3;

		expectedListOfMovements.add("Move Disk 1 from A to B");
		expectedListOfMovements.add("Move Disk 2 from A to C");
		expectedListOfMovements.add("Move Disk 1 from B to C");
		expectedListOfMovements.add("Move Disk 3 from A to B");
		expectedListOfMovements.add("Move Disk 1 from C to A");
		expectedListOfMovements.add("Move Disk 2 from C to B");
		expectedListOfMovements.add("Move Disk 1 from A to B");
		
		listOfMovements = towerOfHanoi.towerOfHanoi(source, destination, auxiliary, numberOfDisk);
		
		Iterator<String> itr=listOfMovements.iterator();  
		System.out.println("For Three Disks");  
		while(itr.hasNext()){  
			System.out.println(itr.next());  
		}  
	  
		assertEquals("ArrayList should be equal",expectedListOfMovements, listOfMovements);
	}
	
}
