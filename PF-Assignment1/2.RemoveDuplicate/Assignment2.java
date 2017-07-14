/*
 * Assignment1
 *
 * Date: 13/07/2017
 *
 */
public class Assignment2 {
	
	/*
	 *  Removes duplicates from an array
	 *  @param input int[]
	 *  @return int[] finalOutput
	 */
	int[] removeDuplicate(int input[]){
		int len = input.length;
		
		int k=0;							
		//keep track of index in output array 
		
		int[] output = new int[len];
		
		/* Comparison loop*/
		for(int i=0; i<len; i++){
			int flag=0;
			for(int j=0; j<i; j++){
				if(input[j] == input[i]){
					flag=1;
					break;
				}
			}
			if(flag!=1){
				output[k++]=input[i];
			}
		}
		
		//Assignment into a new array of required length
		int[] finalOutput = new int[k];
		for (int i = 0; i < finalOutput.length; i++) {
			finalOutput[i] = output[i];
		}
		
		return finalOutput;
	}
	
}
