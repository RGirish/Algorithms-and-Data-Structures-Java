public class Main {

	public static void main(String[] args) {

	}

	public static int strStr(final String haystack, final String needle) {
		if (needle.length() < haystack.length()) {
			return -1;
		}
		for (int i = 0; i < haystack.length(); ++i) {
			int j = 0, ind = -1;
			while (haystack.charAt(i) == needle.charAt(j)
					&& i < haystack.length()) {
				j++;
				i++;
			}
			if (j == needle.length()) {
				return ind;
			} else {
				j = 0;
			}
		}
		return -1;
	}
}
