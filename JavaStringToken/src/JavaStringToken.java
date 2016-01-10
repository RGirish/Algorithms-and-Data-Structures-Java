import java.util.ArrayList;
import java.util.Scanner;

public class JavaStringToken {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		
		/* Method 1 */
		
		String[] words = s.trim().split("[ !,?._'@]+");
		System.out.println(words.length);
		for (String word : words) {
			System.out.println(word);
		}
		
		/* Method 2 - works for all cases*/
		
		int n = 0;
		ArrayList<String> list = new ArrayList<String>();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);
			if ('A' <= ch && ch <= 'Z' || 'a' <= ch && ch <= 'z') {
				builder.append(ch);
			} else {
				if (builder.length() > 0) {
					list.add(builder.toString());
					builder = new StringBuilder();
					n++;
				}
			}
		}
		if (builder.length() != 0) {
			list.add(builder.toString());
			n++;
		}
		System.out.println(n);
		for (String string : list) {
			System.out.println(string);
		}
		scan.close();
	}

}