/*
 * Assignment1
 *
 * Date: 13/07/2017
 *
 */

public class Assignment1 {
	
	/*
	 *  Converts Binary Number to Octal
	 *  @param n int
	 *  @return int octal of binary number
	 */
	int convertBinaryToOctal(int n){
		int x,y,z;	
		//temporary variables to hold modulus and quotient
		
		int groupThree=1; 
		int iterate;
		int octal=0;
		
		x=n;
		
		while(x>0){
			/*
			 * while loop starts
			 * divides the binary number into a block of 3 digits
			 */
			y = x%1000;
			iterate =1;
			z=0;
			while(y>0){
				/*
				 * Inner while loop
				 * multiplies 3 digits with 4, 2 and 1 respectively
				 */
				
				//if condition checks whether digit is binary or not
				if(y%10>1){
					return -1;
				}
				z += (y%10)*iterate;
				iterate *= 2;
				y /= 10;
			}
			
			octal = octal + z*groupThree ;
			groupThree*=10;
			
			x = x/1000;
		}
		return octal;
	}
}
