import java.util.ArrayList;
import java.util.List;

public class LinkedList {

	ListNode firstNode = null;
	List<Integer> list = new ArrayList<>();

	LinkedList(int n) {
		firstNode = new ListNode();
		firstNode.setValue(n);
		firstNode.setNextNode(null);
	}

	public boolean insert(int n) {
		ListNode temp = firstNode;
		while (temp.next != null) {
			temp = temp.next;
		}
		ListNode newNode = new ListNode();
		newNode.setValue(n);
		newNode.setNextNode(null);
		temp.next = newNode;
		return true;
	}

	public void print() {
		ListNode temp = firstNode;
		while (temp != null) {
			System.out.print(temp.val + " -> ");
			temp = temp.next;
		}
		System.out.print("END");
		System.out.println();
	}

	public void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
		System.out.print("END");
		System.out.println();
	}

	public void removeFirst(int n) {
		if (firstNode.val == n) {
			firstNode = firstNode.next;
			return;
		}
		ListNode previous = firstNode;
		ListNode current = firstNode;
		while (current != null) {
			if (current.val == n) {
				previous.next = current.next;
				return;
			}
			previous = current;
			current = current.next;
		}
	}

	public void removeAll(int n) {
		while (firstNode.val == n) {
			firstNode = firstNode.next;
		}
		ListNode previous = firstNode;
		ListNode current = firstNode;
		while (current != null) {
			if (current.val == n) {
				previous.next = current.next;
				current = current.next;
				continue;
			}
			previous = current;
			current = current.next;
		}
	}

	public void search(int n) {
		ListNode temp = firstNode;
		while (temp != null) {
			if (temp.val == n) {
				System.out.println(n + " exists.");
				return;
			}
			temp = temp.next;
		}
		System.out.println(n + " does not exist.");
	}

	public ListNode reverseSecondHalf(ListNode node) {
		ListNode head = node;
		ListNode slow = node;
		ListNode fast = node;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// Halfway reached. Start reversing.
		ListNode prev = slow.next;
		ListNode curr = prev.next;
		if (curr == null)
			return head;
		ListNode next = curr.next;
		prev.next = null;
		while (curr != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			if (next != null) {
				next = next.next;
			}
		}
		slow.next = prev;
		return head;
	}

	public ListNode reverseBetween(ListNode node, int i, int j) {
		ListNode head = node;

		// Traverse to the ith position
		int pos = 0;
		ListNode beforei = null;
		while (node != null && pos < i) {
			pos++;
			beforei = node;
			node = node.next;
		}

		// Start to reverse, go till the jth position
		ListNode firstPrev = node;
		ListNode prev = node;
		ListNode curr = node.next;
		ListNode next = curr.next;
		while (curr != null && pos < j) {
			curr.next = prev;
			prev = curr;
			curr = next;
			if (next != null) {
				next = next.next;
			}
			pos++;
		}
		firstPrev.next = curr;
		if (beforei == null) {
			return prev;
		} else {
			beforei.next = prev;
		}
		return head;
	}

	public ListNode reverse(ListNode node) {
		ListNode prev = node;
		ListNode curr = node.next;
		if (curr == null) {
			return node;
		}
		ListNode next = curr.next;
		prev.next = null;
		while (curr != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			if (next != null) {
				next = next.next;
			}
		}
		return prev;
	}

	public ListNode rotate(ListNode node, int times) {
		ListNode orgHead = node;
		ListNode temp = node;
		int length = 0;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		times = times % length;
		if (times == 0)
			return orgHead;
		temp = node;
		int count = 0;
		ListNode end = null;
		while (count < (length - times)) {
			if (count == length - times - 1) {
				end = temp;
			}
			temp = temp.next;
			count++;
		}
		end.next = null;
		ListNode head = temp;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = orgHead;
		firstNode = head;
		return head;
	}

	public ListNode removeDuplicatesFromSortedList(ListNode node) {
		ListNode head = node;
		ListNode temp = node;
		while (temp != null) {
			while (temp.next != null && temp.val == temp.next.val) {
				temp.next = temp.next.next;
			}
			temp = temp.next;
		}
		return head;
	}

	public int isPalindrome1(ListNode node) {
		reverseReadLinkedList(node);
		ListNode temp = node;
		int i = 0;
		while (temp != null) {
			if (temp.val != list.get(i)) {
				return 0;
			}
			temp = temp.next;
			i++;
		}
		return 1;
	}

	private void reverseReadLinkedList(ListNode node) {
		if (node.next == null) {
			list.add(node.val);
		} else {
			reverseReadLinkedList(node.next);
			list.add(node.val);
		}
	}

	public ListNode reverseAlternateLinks(ListNode node) {
		ListNode A = node;
		ListNode B = A.next;
		ListNode head = B;
		ListNode C = B.next;
		ListNode D = C.next;
		while (D != null) {
			B.next = A;
			A.next = D;
			A = C;
			B = D;
			C = D.next;
			if (C != null)
				D = C.next;
			else
				D = null;
		}
		B.next = A;
		if (C == null) {
			A.next = null;
		} else {
			A.next = C;
		}
		return head;
	}
}