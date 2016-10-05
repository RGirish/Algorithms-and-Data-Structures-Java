public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList(-1);
		list.insert(3);
		list.insert(5);
		list.insert(10);
		list.print();

		LinkedList listB = new LinkedList(0);
		listB.insert(2);
		listB.insert(4);
		listB.insert(5);
		listB.insert(6);
		listB.insert(20);
		listB.insert(25);
		listB.print();

		ListNode node = list.mergeSortedLists2(list.firstNode, listB.firstNode);
		list.print(node);
	}
}