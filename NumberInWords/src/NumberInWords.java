
public class NumberInWords {

	static String[] numbers = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", };
	static String[] tensPosition = { "", "", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty",
			"ninety" };
	static String[] positions = { "", "", "hundred", "thousand" };

	public static void main(String[] args) {
		System.out.println(numberInWords(100200000333l));
	}

	static String numberInWords(long n) {
		String N = String.valueOf(n);
		StringBuilder builder = new StringBuilder();

		if (N.length() >= 10 && N.length() <= 12) {
			String s = numberInWords(Integer.parseInt(N.substring(0, N.length() - 9)));
			if (!s.trim().equals(""))
				builder.append(s + " billion ");
			N = N.substring(N.length() - 9, N.length());
		}
		if (N.length() >= 7 && N.length() <= 9) {
			String s = numberInWords(Integer.parseInt(N.substring(0, N.length() - 6)));
			if (!s.trim().equals(""))
				builder.append(s + " million ");
			N = N.substring(N.length() - 6, N.length());
		}
		if (N.length() >= 5 && N.length() <= 6) {
			String s = numberInWords(Integer.parseInt(N.substring(0, N.length() - 3)));
			if (!s.trim().equals(""))
				builder.append(s + " thousand ");
			N = N.substring(N.length() - 3, N.length());
		}
		for (int i = 0; i < N.length(); ++i) {
			int k = Integer.parseInt(String.valueOf(N.charAt(i)));
			if (i + 2 == N.length()) {
				int k2 = Integer.parseInt(String.valueOf(N.charAt(i + 1)));
				if (!builder.toString().equals("") && !(k == 0 && k2 == 0))
					builder.append("and ");
				if (k == 1) {
					if (k2 == 0) {
						builder.append("ten");
					} else if (k2 == 1) {
						builder.append("eleven");
					} else if (k2 == 2) {
						builder.append("twelve");
					} else if (k2 == 3) {
						builder.append("thirteen");
					} else {
						builder.append(numbers[k2] + "teen");
					}
					break;
				} else if (k > 1 && k2 == 0) {
					builder.append(tensPosition[Integer.parseInt(String.valueOf(N.charAt(i)))]);
					break;
				} else {
					builder.append(tensPosition[k] + " ");
				}
			} else if (i + 1 == N.length()) {
				builder.append(numbers[k] + " ");
			} else {
				if (k != 0)
					builder.append(numbers[k] + " " + positions[N.length() - i - 1] + " ");
			}
		}
		return builder.toString().replaceAll(" +", " ").trim();
	}

}