
public class NumberInWords {

	static String[] numbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten", };
	static String[] tensPosition = { "", "", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty",
			"ninety" };
	static String[] positions = { "", "", "hundred", "thousand" };

	public static void main(String[] args) {
		System.out.println(numberInWords(1435));
	}

	static String numberInWords(int n) {
		String N = String.valueOf(n);
		StringBuilder builder = new StringBuilder();

		if (N.length() >= 5 && N.length() <= 6) {
			builder.append(numberInWords(Integer.parseInt(N.substring(0, N.length() - 3))));
		}
		for (int i = 0; i < N.length(); ++i) {
			int k = Integer.parseInt(String.valueOf(N.charAt(i)));
			if (i + 2 == N.length()) {
				if (!builder.toString().equals(""))
					builder.append("and ");
				int k2 = Integer.parseInt(String.valueOf(N.charAt(i + 1)));
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
				builder.append(numbers[k] + " " + positions[N.length() - i - 1] + " ");
			}
		}
		return builder.toString();
	}

}