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

	// What a rookie would do
	public ListNode mergeSortedLists(ListNode A, ListNode B) {
		ListNode head = A;
		ListNode currA = head, prevA = head;
		ListNode currB = B;

		// If headB is smaller, make that the head of A
		if (currB.val <= currA.val) {
			ListNode newNode = new ListNode();
			newNode.val = currB.val;
			newNode.next = currA;
			head = newNode;
			currB = currB.next;
			currA = prevA = head;
		}

		// Loop till either of the curr's become null
		outerloop: while (currA != null && currB != null) {
			// Move ahead as long as currA is smaller when compared to currB
			while (currA.val < currB.val) {
				prevA = currA;
				currA = currA.next;
				if (currA == null) {
					break outerloop;
				}
			}

			// At this point, currA larger than currB. So insert currB before
			// currA
			ListNode newNode = new ListNode();
			newNode.val = currB.val;
			newNode.next = currA;
			prevA.next = newNode;
			prevA = newNode;

			// Advance currB
			currB = currB.next;
		}

		// At this point, it either means we're done inserting all of B's nodes
		// into A or it means that we've come to the end of A. The following
		// block is to take care of the case when we exit the while by reaching
		// the end of A.
		if (currA == null && currB != null) {
			while (currB != null) {
				ListNode newNode = new ListNode();
				newNode.val = currB.val;
				newNode.next = null;
				prevA.next = newNode;
				prevA = newNode;
				currB = currB.next;
			}
		}
		// For the other case (exiting the while by exhausting B, we do not need
		// to do anything more)
		return head;
	}

	// What a pro would do
	// No extra space, O(N + M)
	public ListNode mergeSortedLists2(ListNode A, ListNode B) {
		ListNode backup = A;
		ListNode ca, cb;
		ca = A;
		cb = B;
		if (B.val < A.val) {
			backup = B;
			cb = cb.next;
		} else {
			backup = A;
			ca = ca.next;
		}
		ListNode temp = backup;
		while (ca != null && cb != null) {
			if (cb.val < ca.val) {
				temp.next = cb;
				temp = temp.next;
				cb = cb.next;
			} else {
				temp.next = ca;
				temp = temp.next;
				ca = ca.next;
			}
		}
		if (cb != null) {
			temp.next = cb;
		} else if (ca != null) {
			temp.next = ca;
		}
		return backup;
	}

	public ListNode removeNthNodeFromEnd(ListNode head, int n) {
		if (n <= 0 || head == null)
			return head;
		ListNode fast = head;
		for (int i = 0; i < n && fast != null; ++i, fast = fast.next)
			if (fast.next == null && i == n - 1)
				return head.next;
		if (fast == null)
			return head.next;
		ListNode slow = head, slowp = head;
		while (fast != null) {
			fast = fast.next;
			slowp = slow;
			slow = slow.next;
		}
		slowp.next = slow.next;
		return head;
	}
}