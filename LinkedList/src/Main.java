public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		list.insert(50);
		list.insert(60);
		list.print();

		Node node = list.reverseSecondHalf(list.firstNode);
		list.print(node);
	}
}