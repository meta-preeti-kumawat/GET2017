/**
 * 
 * @author Preeti Kumawat
 * ClassName: RecursiveSort
 * Date: 17-07-17
 *
 */
public class RecursiveSort {
	
	/**
	 * @param array int[] 
	 * @param start_index int
	 * @param end_index int
	 */
	public void quickSort(int[] array, int start_index, int end_index){
		int pivotIndex;
		if(start_index < end_index){
			pivotIndex = partitionArray(array,start_index, end_index);
			
			quickSort(array, start_index, pivotIndex -1);  //Recursion for elements smaller than pivot element
			quickSort(array, pivotIndex + 1, end_index);  	//Recursion for elements larger than pivot element
		}
	}
	
	/**
	 * Partitions the array according to the pivotIndex element
	 * @param array int[]
	 * @param start_index int
	 * @param end_index int
	 * @return int pivotIndex
	 * pivot element is the first element of respective array
	 */
	public int partitionArray(int[] array,int start_index, int end_index){
		int pivotIndex = start_index;
		int flag;
		int minIndex = start_index+1;
		int maxIndex = end_index;
		
		while(minIndex <= maxIndex){
			flag = 0;
			if(array[minIndex] < array[pivotIndex] && minIndex<=end_index){
				//increment minimum index until a greater value than pivot is encountered 
				minIndex++;
				flag = 1;
			}
			
			if(array[maxIndex] > array[pivotIndex] && maxIndex>=start_index){
				//decrement maximum index until a smaller value than pivot is encountered
				maxIndex--;
				flag = 1;
			}
			if(flag == 0 && maxIndex>minIndex){
				//swap element at Min Index with element at Max Index if min Index is less than Max Index
				int temp = array[maxIndex];
				array[maxIndex] = array[minIndex];
				array[minIndex] = temp;
				
			}
			
		}
		
		//swap pivot element and element at Max index when minimum index is greater than maximum Index
		int temp = array[pivotIndex];
		array[pivotIndex] = array[maxIndex];
		array[maxIndex] = temp;
		
		//return index of pivot element
		return pivotIndex;
	}
	
}
