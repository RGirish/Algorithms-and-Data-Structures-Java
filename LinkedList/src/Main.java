
public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList(20);
		list.insert(20);
		list.insert(20);
		list.insert(20);
		list.insert(50);
		list.insert(30);
		list.insert(90);
		list.insert(100);
		list.insert(20);
		list.insert(20);
		list.insert(20);
		list.insert(20);
		list.insert(20);
		list.insert(30);
		list.insert(30);
		list.insert(20);
		list.insert(20);
		list.insert(20);
		list.insert(20);
		list.print();

		list.removeFirst(20);
		list.print();

		list.removeAll(20);
		list.print();

		list.search(909);
		
		list.reverse();
		list.print();
	}

}