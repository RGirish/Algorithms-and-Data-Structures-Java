import java.util.Scanner;

public class LexiSubStr {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		int n = scan.nextInt();
		scan.close();

		String minSubString, maxSubString;
		minSubString = maxSubString = line.substring(0, n);
		for (int i = 1; i + n <= line.length(); ++i) {
			String temp = line.substring(i, i + n);
			if (minSubString.compareTo(temp) > 0)
				minSubString = temp;
			if (maxSubString.compareTo(temp) < 0)
				maxSubString = temp;
		}

		System.out.println(minSubString);
		System.out.println(maxSubString);
	}

}
