/*
 * Assignment3
 * 
 * Date: 14/07/2017
 * 
 * This class solves the third problem of Programming fundamentals session 1
 * To find the longest increasing sequence
 */
public class Assignment3 {
	int countSeq = 1; 
	int maxSeq = 1;
	
	/*
	 *  Finds longest sequence
	 *  @param input int[]
	 *  @return int[] output
	 */
	int[] longestSequence(int input[]){
		int flag=0; 
		int currentIndex=0;
		int indexMax=0;;
		int len = input.length;
		 
		 for(int i=1; i<len; i++){
			 if(input[i] - input[i-1] >= 1){
				 countSeq++;
			 }
			 else{
				 indexMax = maxSeq >= countSeq? indexMax: currentIndex;
				 maxSeq = maxSeq >= countSeq? maxSeq: countSeq;
				 System.out.println(maxSeq+" "+indexMax);
				 currentIndex = i;
				 countSeq = 1;
			 }
		 }
		 
		 //compare past maximum sequence with recent sequence
		 flag = (maxSeq >= countSeq) ? maxSeq : countSeq; 
		 indexMax = (maxSeq >= countSeq) ? indexMax : currentIndex; 
		 System.out.println("flag "+flag);
		 System.out.println("Index "+indexMax);
		 int[] output = new int[flag];
		 for(int i=0; i<flag; i++,indexMax++){
			 output[i] = input[indexMax];
		 }
		 
		 return output;
	 }

}
