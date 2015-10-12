/*
 * Not from CTCI. This prints the max continuous subset sum inside the array.
 */
package girish.ctci.project;

public class MaxSubset {
	
	static int[] array = {-100, 10, 5, -1, -12, -2, -16, -3000};
	static int current_total = 0, max = 0;
	static int maxval;
	
	public static void main(String[] args){
		max = array[0];
		for(int i=0 ; i<array.length ; ++i){
			current_total+=array[i];
			if(current_total > max) max = current_total;
			if(current_total <= 0) current_total = 0;
		}
		System.out.println(max);
	}	
}