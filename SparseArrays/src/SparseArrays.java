import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SparseArrays {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter N: ");
		int N = Integer.parseInt(scan.nextLine());
		HashMap<String, Integer> list = new HashMap<String, Integer>();
		System.out.println("Enter " + N + " strings: ");
		
		for (int i = 0; i < N; i++) {
			String s = scan.nextLine();
			if (list.containsKey(s)) {
				list.replace(s, list.get(s) + 1);
			} else {
				list.put(s, 1);
			}
		}
		System.out.println("Enter Q: ");
		int Q = Integer.parseInt(scan.nextLine());
		System.out.println("Enter " + Q + " queries: ");
		ArrayList<Integer> counts = new ArrayList<>();
		for (int i = 0; i < Q; ++i) {
			String s = scan.nextLine();
			if (list.containsKey(s))
				counts.add(list.get(s));
			else
				counts.add(0);
		}
		for (int i : counts) {
			System.out.println(i);
		}
		scan.close();
	}

}