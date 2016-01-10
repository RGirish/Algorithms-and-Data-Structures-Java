package girish.hacker.rank;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class StringsIntro {

	public static void main(String[] args) {

		/* Basics */

		/*
		 * String A = "girish"; String B = "gayathri";
		 * System.out.println(A.length() + B.length()); if
		 * (A.compareToIgnoreCase(B) > 0) { System.out.println("YES"); } else if
		 * (A.compareToIgnoreCase(B) < 0) { System.out.println("NO"); } char[] a
		 * = A.toCharArray(); a[0] -= 32; char[] b = B.toCharArray(); b[0] -=
		 * 32; System.out.println(String.valueOf(a) + " " + String.valueOf(b));
		 * 
		 * Palindrome
		 * 
		 * Scanner sc = new Scanner(System.in); A = sc.next(); boolean flag =
		 * false; for (int i = 0; i < A.length() / 2 + 1; ++i) { if (A.charAt(i)
		 * != A.charAt(A.length() - i - 1)) { flag = true; break; } } if (flag)
		 * System.out.println("No"); else System.out.println("Yes");
		 */

		/* Anagrams */

		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		boolean ret = isAnagram2(A, B);
		if (ret)
			System.out.println("Anagrams");
		else
			System.out.println("Not Anagrams");
		sc.close();
	}

	public static boolean isAnagram(String A, String B) {
		if (A.length() != B.length())
			return false;

		A = A.toLowerCase();
		B = B.toLowerCase();

		HashMap<String, Integer> Amap = new HashMap<>();
		HashMap<String, Integer> Bmap = new HashMap<>();

		for (int i = 0; i < A.length(); ++i) {
			if (!Amap.containsKey(String.valueOf(A.charAt(i)))) {
				Amap.put(String.valueOf(A.charAt(i)), 1);
			} else {
				Amap.put(String.valueOf(A.charAt(i)), Amap.get(String.valueOf(A.charAt(i))) + 1);
			}
		}

		for (int i = 0; i < B.length(); ++i) {
			if (!Bmap.containsKey(String.valueOf(B.charAt(i)))) {
				Bmap.put(String.valueOf(B.charAt(i)), 1);
			} else {
				Bmap.put(String.valueOf(B.charAt(i)), Bmap.get(String.valueOf(B.charAt(i))) + 1);
			}
		}

		Iterator it = Amap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if (Bmap.get(pair.getKey()) != pair.getValue())
				return false;
			it.remove();
		}
		return true;
	}

	public static boolean isAnagram2(String A, String B) {
		if (A.length() != B.length())
			return false;
		StringBuilder builder = new StringBuilder();
		builder.append(A.toLowerCase());
		builder.append(B.toLowerCase());
		String C = builder.toString();
		byte sum = 0x00;
		for (int i = 0; i < C.length(); ++i) {
			sum ^= (byte) C.charAt(i);
		}
		if (sum != 0x00)
			return false;
		return true;
	}
}