public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList(1);
		list.print();

		ListNode node = list.reorderList2(list.firstNode);
		list.print(node);
	}
}