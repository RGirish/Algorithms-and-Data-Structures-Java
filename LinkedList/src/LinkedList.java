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

	public void print(Node node) {
		while (node != null) {
			System.out.print(node.n + " -> ");
			node = node.nextNode;
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

	public Node reverseSecondHalf(Node node) {
		Node head = node;
		Node slow = node;
		Node fast = node;
		while (fast.nextNode != null && fast.nextNode.nextNode != null) {
			slow = slow.nextNode;
			fast = fast.nextNode.nextNode;
		}

		// Halfway reached. Start reversing.
		Node prev = slow.nextNode;
		Node curr = prev.nextNode;
		if (curr == null)
			return head;
		Node next = curr.nextNode;
		prev.nextNode = null;
		while (curr != null) {
			curr.nextNode = prev;
			prev = curr;
			curr = next;
			if (next != null) {
				next = next.nextNode;
			}
		}
		slow.nextNode = prev;
		return head;
	}

	public Node reverseBetween(Node node, int i, int j) {
		Node head = node;

		// Traverse to the ith position
		int pos = 0;
		Node beforei = null;
		while (node != null && pos < i) {
			pos++;
			beforei = node;
			node = node.nextNode;
		}

		// Start to reverse, go till the jth position
		Node firstPrev = node;
		Node prev = node;
		Node curr = node.nextNode;
		Node next = curr.nextNode;
		while (curr != null && pos < j) {
			curr.nextNode = prev;
			prev = curr;
			curr = next;
			if (next != null) {
				next = next.nextNode;
			}
			pos++;
		}
		firstPrev.nextNode = curr;
		if (beforei == null) {
			return prev;
		} else {
			beforei.nextNode = prev;
		}
		return head;
	}

	public Node reverse(Node node) {
		Node prev = node;
		Node curr = node.nextNode;
		if (curr == null) {
			return node;
		}
		Node next = curr.nextNode;
		prev.nextNode = null;
		while (curr != null) {
			curr.nextNode = prev;
			prev = curr;
			curr = next;
			if (next != null) {
				next = next.nextNode;
			}
		}
		return prev;
	}

	public Node rotate(Node node, int times) {
		Node orgHead = node;
		Node temp = node;
		int length = 0;
		while (temp != null) {
			length++;
			temp = temp.nextNode;
		}
		times = times % length;
		if (times == 0)
			return orgHead;
		temp = node;
		int count = 0;
		Node end = null;
		while (count < (length - times)) {
			if (count == length - times - 1) {
				end = temp;
			}
			temp = temp.nextNode;
			count++;
		}
		end.nextNode = null;
		Node head = temp;
		while (temp.nextNode != null) {
			temp = temp.nextNode;
		}
		temp.nextNode = orgHead;
		firstNode = head;
		return head;
	}
}