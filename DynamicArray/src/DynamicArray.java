import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DynamicArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int Q = scan.nextInt();
		
		List<LinkedList<Integer>> list = new ArrayList<LinkedList<Integer>>(N);
        for(int i = 0 ; i < N ; ++i) {
            list.add(new LinkedList<Integer>());
        }
		
        int lastans = 0;
		List<Integer> output = new ArrayList<Integer>();
        
		for (int i = 0; i < Q; ++i) {
			int type = scan.nextInt();
			int x = scan.nextInt();
			int y = scan.nextInt();
			int listPos = (x ^ lastans) % N;
			if (type == 1) {
				list.get(listPos).add(y);
			} else if (type == 2) {
				LinkedList<Integer> temp = list.get(listPos); 
				int elePos = y % temp.size();
				int ele = temp.get(elePos);
                lastans = ele;
                output.add(ele);
			}
		}
		
		for(int a : output) {
			System.out.println(a);
		}
        scan.close();
    }
}