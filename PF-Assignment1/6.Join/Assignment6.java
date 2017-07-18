/*
 * Assignment5
 * 
 * Date: 14/07/2017
 * 
 * This class solves the 5th problem of Programming fundamentals session 1
 * merge two sorted array
 */

public class Assignment6 {
	/*
	 * merges two sorted arrays into a third array 
	 * @param a int[]
	 * @param asize int
	 * @param b int[]
	 * @param bsize int
	 * @param a int[]
	 * @return int[] c
	 */
	int[] join(int a[], int asize, int b[], int bsize, int c[]){
		int i=0, j=0;
		int k=-1;
		
		//check whether arrays are sorted or not
		Assignment5 assignment5 = new Assignment5();
		int output=assignment5.checkSortedArray(a);
		if(output == 1){
			output=assignment5.checkSortedArray(b);
			
			if(output == 1){
		
				while(i<asize && j<bsize){
					if(a[i]<=b[j]){
						c[++k]=a[i++];
					}
					else{
						c[++k]=b[j++];
					}
				}
				if(i==asize && j<bsize){
					while(j<bsize){
						c[++k]=b[j++];
					}
				}
				else if(j==bsize && i<asize){
					while(i<asize){
						c[++k]=a[i++];
					}
				}
			}
		}
		if(output != 1){
			System.out.println("Input arrays are not sorted");
		}
		return c;
	}
}
