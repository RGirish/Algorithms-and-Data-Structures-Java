public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList(10);
		list.insert(20);
		list.insert(10);
		//list.print();

		int isPalindrome = list.isPalindrome1(list.firstNode);
		System.out.println(isPalindrome);
	}
}