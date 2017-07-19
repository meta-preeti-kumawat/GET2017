/**
 * 
 * @author Preeti Kumawat
 * ClassName: RecursiveSearch
 * Date: 17-07-17
 *
 */
public class RecursiveSearch {
	
	/**
	 * @param array int[] 
	 * @param start_index int
	 * @param number int to be searched
	 * @return boolean flag (True on successful search otherwise False)
	 */
	public boolean linearSearch(int[] array, int start_index, int number){
		boolean flag=false;
		
		if(start_index < array.length && array[start_index] != number){
			flag = linearSearch(array, start_index + 1, number);
		}
		else if(start_index == array.length){
			flag = false;
		}
		else{
			flag = true;
		}
		
		return flag;
	}
	
	/**
	 * It is considered that input array is sorted
	 * @param array int[] 
	 * @param start_index int
	 * @param end_index int
	 * @param number int to be searched
	 * @return boolean flag
	 */
	public boolean binarySearch(int[] array, int start_index, int end_index, int number){
		boolean flag=false;
		int mid_index = (start_index + end_index)/2;
		
		if(start_index < end_index && array[mid_index] == number){
			flag = true;
		}
		else if(array[mid_index] > number){
			flag = binarySearch(array, start_index, mid_index-1, number);
		}
		else if(array[mid_index] < number){
			flag = binarySearch(array, mid_index+1, end_index, number);
		}
		else{
			flag = false;
		}
		
		return flag;
	}
}
