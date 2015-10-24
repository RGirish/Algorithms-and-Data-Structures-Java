package girish.hackerrank.project;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scan = new Scanner(System.in);
		int N;
		do {
			N = scan.nextInt();
		} while (!(N >= 1 && N <= 100));
		int sumLR = 0, sumRL = 0;
		int LRi = 1, RLi = N;
		for (int i = 1; i <= N*N; ++i) {
			int t = scan.nextInt();
			if(i==LRi && i==RLi){
				sumLR += t;
				sumRL += t;
				System.out.println("sumRL" + sumRL);
				System.out.println("sumLR" + sumLR);
			}else if(i==LRi){
				sumLR += t;
				System.out.println("sumLR" + sumLR);
				LRi += (N+1);
			}else if(i==RLi){
				sumRL += t;
				RLi += (N-1);
				System.out.println("sumRL" + sumRL);
			}
		}
		System.out.println(Math.abs(sumLR));
		System.out.println(Math.abs(sumRL));
		System.out.println(Math.abs(sumLR - sumRL));
	}

}
