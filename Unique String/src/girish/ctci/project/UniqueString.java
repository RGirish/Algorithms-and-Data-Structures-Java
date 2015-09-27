/**
 * @author Girish Raman
 * Checks if a String has all unique characters, without using any data structures!
 */
package girish.ctci.project;

public class UniqueString {

	public static void main(String[] a) {

		String s = "asdqwea";
		boolean flag = false;

		for (int i = s.length() - 1; i >= 0; --i) {
			for (int j = i - 1; j >= 0; --j) {
				if (s.charAt(j) == s.charAt(i)) {
					flag = true;
					System.out.println("String has duplicate characters!");
					break;
				}
			}
			if (flag)
				break;
		}
		if (!flag)
			System.out.println("String doesn't have duplicate characters!");

	}

}