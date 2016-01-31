
public class BinaryPalindrome {

	public static void main(String[] args) {
		int n = 5;
		int ncopy = n;
		int n2 = 0;
		while (n != 0) {
			n2 = n2 << 1;
			if ((n & 1) == 1) {
				n2 += 1;
			}
			n = n >> 1;
		}

		if (ncopy == n2) {
			System.out.println("Palindrome");
		} else {
			System.out.println("Not a Palindrome");
		}
	}

}
