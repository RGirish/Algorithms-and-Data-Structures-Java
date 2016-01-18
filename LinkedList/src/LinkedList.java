
public class LinkedList {

	Node firstNode = null;

	LinkedList(int n) {
		firstNode = new Node();
		firstNode.setValue(n);
		firstNode.setNextNode(null);
	}

	public boolean insert(int n) {
		Node temp = firstNode;
		while (temp.nextNode != null) {
			temp = temp.nextNode;
		}
		Node newNode = new Node();
		newNode.setValue(n);
		newNode.setNextNode(null);
		temp.nextNode = newNode;
		return true;
	}

	public void print() {
		Node temp = firstNode;
		while (temp != null) {
			System.out.print(temp.n + " -> ");
			temp = temp.nextNode;
		}
		System.out.print("END");
		System.out.println();
	}

	public void removeFirst(int n) {
		if (firstNode.n == n) {
			firstNode = firstNode.nextNode;
			return;
		}
		Node previous = firstNode;
		Node current = firstNode;
		while (current != null) {
			if (current.n == n) {
				previous.nextNode = current.nextNode;
				return;
			}
			previous = current;
			current = current.nextNode;
		}
	}

	public void removeAll(int n) {
		while (firstNode.n == n) {
			firstNode = firstNode.nextNode;
		}
		Node previous = firstNode;
		Node current = firstNode;
		while (current != null) {
			if (current.n == n) {
				previous.nextNode = current.nextNode;
				current = current.nextNode;
				continue;
			}
			previous = current;
			current = current.nextNode;
		}
	}

	public void search(int n) {
		Node temp = firstNode;
		while (temp != null) {
			if (temp.n == n) {
				System.out.println(n + " exists.");
				return;
			}
			temp = temp.nextNode;
		}
		System.out.println(n + " does not exist.");
	}

	void reverse() {
		if (firstNode.nextNode.nextNode == null) {
			Node two = firstNode.nextNode;
			two.nextNode = firstNode;
			firstNode.nextNode = null;
			firstNode = two;
		} else {
			Node previous = firstNode;
			Node previousAhead = previous.nextNode;
			Node current = previousAhead;
			Node currentAhead = current.nextNode;
			int count = 0;
			while (true) {
				previousAhead.nextNode = previous;
				if (count == 0) {
					previous.nextNode = null;
					count++;
				}
				current = currentAhead;
				if (current == null)
					break;
				currentAhead = current.nextNode;
				previous = previousAhead;
				previousAhead = current;
			}
			firstNode = previousAhead;
		}
	}
}