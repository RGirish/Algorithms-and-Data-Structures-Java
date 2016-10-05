public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insert(8);
		list.insert(9);
		list.insert(10);
		list.print();

		ListNode node = list.removeNthNodeFromEnd(list.firstNode, 10);
		list.print(node);
	}
}