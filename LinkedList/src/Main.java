public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		ListNode node = list.createCyclicLinkedList(2, 0, 1, 2, 3, 4, 5, 6);
		list.print(node);
	}
}