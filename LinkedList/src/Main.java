public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList(1);
		list.insert(1);
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(3);
		list.insert(5);
		list.print();

		ListNode node = list.removeDuplicatesFromSortedList2Method1(list.firstNode);
		list.print(node);
	}
}