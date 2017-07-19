import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;
import org.junit.Before;

/**
 * @author Preeti Kumawat
 * Class Name: TestPermutations
 * Date: 18-07-2017
 *
 */
public class TestPermutations {
	private Permutations permutations;
	private String inputString;
	
	private ArrayList<String> possiblePermutations = new ArrayList<String>();
	private ArrayList<String> expectedpossiblePermutations = new ArrayList<String>();

	@Before
	public void initialize() {
		permutations = new Permutations();
	}
	
	@Test
	public void testPermutationsForLengthOfTwo(){
		inputString = "AB";
		
		expectedpossiblePermutations.add("AB");
		expectedpossiblePermutations.add("BA");
		
		possiblePermutations = permutations.generatePermutations(inputString, 0, inputString.length() - 1);
		
		//print ArrayList
		Iterator<String> itr=possiblePermutations.iterator();  
		System.out.println("For Input String: "+inputString);  
		while(itr.hasNext()){  
			System.out.println(itr.next());  
		}
		assertEquals("ArrayList should be equal",expectedpossiblePermutations, possiblePermutations);
	}
	

	@Test
	public void testPermutationsForLengthOfThree(){
		inputString = "ABC";
		
		expectedpossiblePermutations.add("ABC");
		expectedpossiblePermutations.add("ACB");
		expectedpossiblePermutations.add("BAC");
		expectedpossiblePermutations.add("BCA");
		expectedpossiblePermutations.add("CAB");
		expectedpossiblePermutations.add("CBA");
		
		possiblePermutations = permutations.generatePermutations(inputString, 0, inputString.length() - 1);
		
		Iterator<String> itr=possiblePermutations.iterator();  
		System.out.println("For Input String: "+inputString);  
		while(itr.hasNext()){  
			System.out.println(itr.next());  
		}  
		assertEquals("ArrayList should be equal",expectedpossiblePermutations, possiblePermutations);
	}
	
	@Test
	public void testPermutationsForLengthOfThreeWithRepetition(){
		inputString = "AAB";
		
		expectedpossiblePermutations.add("AAB");
		expectedpossiblePermutations.add("ABA");
		expectedpossiblePermutations.add("BAA");
		
		possiblePermutations = permutations.generatePermutations(inputString, 0, inputString.length() - 1);
		
		Iterator<String> itr=possiblePermutations.iterator();  
		System.out.println("For Input String: "+inputString);  
		while(itr.hasNext()){  
		    System.out.println(itr.next());  
		}  
		assertEquals("ArrayList should be equal",expectedpossiblePermutations, possiblePermutations);
	}
	
	@Test
	public void testPermutationsForLengthOfFour(){
		inputString = "ABCD";
		String[] strings = {"ABCD","ABDC","ACBD","ACDB","ADBC","ADCB",
							"BACD","BADC","BCAD","BCDA","BDAC","BDCA",
							"CABD","CADB","CBAD","CBDA","CDAB","CDBA",
							"DABC","DACB","DBAC","DBCA","DCAB","DCBA"};
		expectedpossiblePermutations.addAll(Arrays.asList(strings));
		
		possiblePermutations = permutations.generatePermutations(inputString, 0, inputString.length() - 1);
		
		Iterator<String> itr=possiblePermutations.iterator();  
		System.out.println("For Input String: "+inputString);  
		while(itr.hasNext()){  
		    System.out.println(itr.next());  
		}    
		assertEquals("ArrayList should be equal",expectedpossiblePermutations, possiblePermutations);
	}
}
