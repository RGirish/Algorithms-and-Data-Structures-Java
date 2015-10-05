package girish.project;

public class OddNumber {	
	public static void main(String[] asd){
		int[] a = {1,7,7,1,6,6,-4,7,-4,90,43,43,90};
		int val = a[0];
		for(int i=1; i<a.length ; ++i){
			val = val ^ a[i];
		}
		System.out.println(val);
	}
}