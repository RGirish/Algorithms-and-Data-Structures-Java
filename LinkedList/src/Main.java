public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		ListNode node = list.createCyclicLinkedList(2, 0, 1, 2);
		list.printNNodes(node, 20);
		ListNode reversed = list.reverseTheLoop(node);
		list.printNNodes(reversed, 20);
	}
}