/*
 * Assignment1
 * 
 * Date: 14/07/2017
 * 
 * This class solves the first problem of Programming fundamentals session 2
 * Generate a pattern
 *     
 * 12345
 *  1234
 *   123
 *    12
 *     1
 */

public class Assignment2 {

	/*
	 * create string of spaces
	 * @param rows int
	 * @param n int
	 * @return String space
	 * 
	 */
	String spaces(int rows, int n){
		String space="";
		
		if(rows<=n){
			for(int i=0; i<rows-1; i++){
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
		
		if(rows<=n){
			for(int i=0; i < n-rows+1; i++){
				number= number + String.valueOf(i+1);
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
		for (int rows = 1; rows <= n ; rows++) {
			pattern = pattern+spaces(rows,n)+numbers(rows,n)+"\n";
		}
		String output[] = pattern.split("\n"); 
		return output;
	}
	
}
