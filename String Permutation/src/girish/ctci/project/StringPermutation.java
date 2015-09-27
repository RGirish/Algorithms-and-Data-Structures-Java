/**
 * @author Girish Raman
 * From 'Cracking the Coding Interview'
 * 
 * Checks if a String is a permutation of another.
 */
package girish.ctci.project;

import java.util.HashMap;

public class StringPermutation {

	public static boolean isPermutationOfOther(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}

		// These 2 hashmaps will contain the characters in the respective
		// strings and the count of the number of occurrence.
		HashMap<String, Integer> map_a = new HashMap<>();
		HashMap<String, Integer> map_b = new HashMap<>();
		for (int i = 0; i < a.length(); ++i) {
			if (!map_a.containsKey(String.valueOf(a.charAt(i)))) {
				map_a.put(String.valueOf(a.charAt(i)), 1);
			} else {
				map_a.put(String.valueOf(a.charAt(i)), map_a.get(String.valueOf(a.charAt(i))) + 1);
			}

			if (!map_b.containsKey(String.valueOf(b.charAt(i)))) {
				map_b.put(String.valueOf(b.charAt(i)), 1);
			} else {
				map_b.put(String.valueOf(a.charAt(i)), map_b.get(String.valueOf(b.charAt(i))) + 1);
			}
		}

		// The 2 strings are permutations of each other if their hashmaps are
		// the same.
		if (map_a.keySet().equals(map_b.keySet())) {
			return true;
		}
		return false;
	}

	public static void main(String[] a) {
		if (isPermutationOfOther("Girish", "hsiriG")) {
			System.out.println("It's a Permutation!");
		} else {
			System.out.println("Not a Permutation!");
		}
	}

}