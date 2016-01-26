
public class HammingDistance {

	public static void main(String[] args) {
		String s1 = "this is a test";
		String s2 = "wokka wokka!!!";
		int dist = 0;
		for (int i = 0; i < s1.length(); ++i) {
			int c = s1.charAt(i) ^ s2.charAt(i);
			for (; c > 0; dist++) {
				c &= (c - 1);
			}
		}
		System.out.println(dist);
	}
	
}