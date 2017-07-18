/*
 * Assignment5
 * 
 * Date: 14/07/2017
 * 
 * This class solves the 5th problem of Programming fundamentals session 1
 * Checks whether array is sorted or not
 */

public class Assignment5 {
	
	/*
	 * checks an input array is sorted or not
	 * @param input int[]
	 * @return int flag
	 * flag = 1 for ascending array
	 * flag = 2 for descending array
	 * flag = 0 for unsorted array
	 */
	int checkSortedArray(int input[]){
		int flag = 0;
		int[] difference = new int[input.length - 1];
		//holds difference between 2 adjacent values
		
		for(int i=0; i<input.length-1; i++){
			difference[i] = input[i+1] - input[i];
		}
		int i=0;
		while(i<difference.length){
			flag = (difference[i]>=0) ? 1:0;
			if(flag==0){
				break;
			}
			i++;
		}
		i=0;
		if(flag==0){
			while(i<difference.length){
				flag = (difference[i]<=0) ? 2:0;
				if(flag==0){
					break;
				}
				i++;
			}
		}
		
		return flag;
	}
	
	public void printOutput(int flag){
		System.out.println(flag>0? (flag==1? "Array is in Ascending order" 
										   : "Array is in Descending order") 
								 : "Array is unsorted");
	}
	
}
