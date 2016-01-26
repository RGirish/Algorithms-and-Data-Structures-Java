
public class Main {

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		for (int i = 5; i <= 10; ++i) {
			int k = i;
			while (k > 0) {
				if ((k & 1) == 1) {
					builder.append("1");
				} else {
					builder.append("0");
				}
				k = k >> 1;
			}
			System.out.println(builder.reverse().toString());
			builder.delete(0, builder.length());
		}
	}

}