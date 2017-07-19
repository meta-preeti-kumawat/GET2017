/**
 * 
 * @author Preeti Kumawat
 * ClassName: Recursion
 * Date: 17-07-17
 *
 */
public class Recursion {
	
	/**
	 * @param input1 int (input1>=0)
	 * @param input2 int (input2>0)
	 * @return int remainder
	 */
	int rem(int input1, int input2){
		int remainder=0;
		if(input1>=0 && input2>0){
			if(input1>=input2){
				remainder=rem(input1-input2,input2);
			}
			else{
				remainder = input1;
			}
		}
		else{
			remainder = -1;
		}
		return remainder;
	}

	/**
	 * @param input1 int (input1>0)
	 * @param input2 int (input2>0)
	 * @return int gcd
	 */
	 int gcd(int input1, int input2){
			int gcd=-1;
			if(input1>0 && input2>0){
				if(input1!=input2){
					gcd = input1>input2 ? gcd(input1-input2,input2) : gcd(input1, input2-input1);					
				}
				else{
					gcd = input1;
				}
			}
			
			return gcd;
	 }
	 
	 /**
	 * @param input1 int (input1>0)
	 * @return int maxDigit
	 */
	 int  largestDigit(int input1) {
			int maxDigit; 
			int previousMax;
			if(input1>0){
					maxDigit = input1%10;
					maxDigit = maxDigit > (previousMax=largestDigit(input1/10)) ? maxDigit : previousMax;
			}
			else{
				maxDigit = 0;
			}
			return maxDigit;
	 }
}
