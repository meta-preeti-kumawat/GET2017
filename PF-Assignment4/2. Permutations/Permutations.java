import java.util.ArrayList;

/**
 * @author Preeti Kumawat
 * Class Name: Permutations
 * Date: 18-07-2017
 *
 */
public class Permutations {
	ArrayList<String> possiblePermutations = new ArrayList<String>();
	
	/**
	 * @param inputString
	 * @param index1
	 * @param index2
	 * @return String after swapping
	 */
	public String swap(String inputString, int index1, int index2) {
		char[] characterArray = inputString.toCharArray();
		char temp = characterArray[index1];
		characterArray[index1] = characterArray[index2];
		characterArray[index2] = temp;
		return String.valueOf(characterArray);
	}
	
	/**
	 * @param inputString
	 * @param low_index
	 * @param high_index
	 * @return ArrayList<String>
	 */
	ArrayList<String> generatePermutations(String inputString, int low_index, int high_index){
		
		if(low_index == high_index){
			if(!possiblePermutations.contains(inputString)){
				possiblePermutations.add(inputString);
			}
		}
		else{
			for (int iterateIndex = low_index; iterateIndex <= high_index; iterateIndex++) {
				inputString = swap(inputString, iterateIndex, low_index);
				generatePermutations(inputString, low_index + 1, high_index);
			}
		}
		return possiblePermutations;
	}
}
