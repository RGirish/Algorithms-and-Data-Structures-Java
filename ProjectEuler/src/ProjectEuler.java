import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectEuler {

	public static void main(String[] args) {
		
	}
	
	public static void sumOfMultiplesOfThreeAndFive(){
		Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        List<Long> list = new ArrayList<Long>();
        
        for(int c = 0 ; c < T ; ++c) {
            long N = scan.nextInt();
            long total = 0;
            
            for(long i = N - 1 ; i > 0 ; --i) {
                if (i % 3 == 0) {
                    long q = i / 3;
                    total += (q * (3 + i)) >> 1;
                    break;
                }
            }
            
            for(long i = N - 1 ; i > 0 ; --i) {
                if (i % 5 == 0) {
                    long q = i / 5;
                    total += (q * (5 + i)) >> 1;
                    break;
                }
            }
            
            for(long i = N - 1 ; i > 0 ; --i) {
                if (i % 15 == 0) {
                    long q = i / 15;
                    total -= (q * (15 + i)) >> 1;
                    break;
                }
            }
            
            list.add(total);
            
        }
        
        for(long i : list) {
            System.out.println(i);
        }
        scan.close();
	}
	
	public static void sumOfEvnFibonacci(){
		Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        long total = 0;
        List<Long> list = new ArrayList<Long>();
        for ( int i = 0 ; i < T ; ++i ) {
            long prev = 1;
            long curr = 2;
            long N = scan.nextLong();
            for( ; curr < N ; ) {
                total += curr;

                long temp = curr;
                curr = curr + prev;
                prev = temp;

                temp = curr;
                curr = curr + prev;
                prev = temp;

                temp = curr;
                curr = curr + prev;
                prev = temp;
            }
            list.add(total);
            total = 0;
        }
        
        for(long i : list){
            System.out.println(i);
        }
	}

}