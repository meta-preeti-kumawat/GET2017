/*
 * Assignment1
 * 
 * Date: 14/07/2017
 * 
 * This class solves the first problem of Programming fundamentals session 2
 * Generate a pattern
 *     1
 *    121
 *   12321
 *  1234321
 * 123454321
 *  1234321
 *   12321
 *    121
 *     1
 */

public class Assignment1 {
	
	/*
	 * create string of spaces
	 * @param rows int
	 * @param n int
	 * @return String space
	 * 
	 */
	String spaces(int rows, int n){
		String space="";
		
		if(rows<2*n){
			for(int i=0; i<n-rows; i++){
				space = space + " ";
			}
			for(int i=0; i<rows-n; i++){
				space = space + " ";
			}
		}
		
		return space;
	}
	
	/*
	 * create string of numbers
	 * @param rows int
	 * @param n int
	 * @return String number
	 * 
	 */
	String numbers(int rows, int n){
		String number="";
		int count;
		
		if(rows<2*n){
			if(rows<=n){
				count=2*rows -1;
			}
			else{
				count=2*(2*n - rows)-1;
			}
			
			
			for(int i=0; i < count; i++){
				if(i <= count/2){
					number= number + String.valueOf(i+1);
				}
				else{
					number= number + String.valueOf(count-i);
				}
			}
		}
		
		return number;
	}
	
	/*
	 * create string array of pattern ( row-wise)
	 * @param n int
	 * @return String[] output
	 * 
	 */
	String[] pyramid(int n){
		String pattern="";
		for (int rows = 1; rows < 2*n ; rows++) {
			pattern = pattern+spaces(rows,n)+numbers(rows,n)+spaces(rows,n)+"\n";
		}
		String output[] = pattern.split("\n"); 
		return output;
	}
	
}
