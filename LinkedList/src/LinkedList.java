import java.util.ArrayList;
import java.util.List;

public class LinkedList {

	ListNode firstNode = null;
	List<Integer> list = new ArrayList<>();

	LinkedList(int n) {
		firstNode = new ListNode(0);
		firstNode.setValue(n);
		firstNode.setNextNode(null);
	}

	public LinkedList() {
		firstNode = null;
	}

	/**
	 * Given a linked list with a loop in it, reverses the loop.
	 */
	public ListNode reverseTheLoop(ListNode a) {
		ListNode slow = a, fast = a;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				break;
			}
		}
		if (fast == null || fast.next == null) {
			System.out.println("List does not have a cycle in it.");
			return null;
		}
		slow = a;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		fast = fast.next;
		ListNode ahead = fast.next;
		slow.next = null;
		while (ahead != null) {
			fast.next = slow;
			slow = fast;
			fast = ahead;
			ahead = ahead.next;
		}
		fast.next = slow;
		return a;
	}

	/**
	 * Creates a linked list with a cycle in it, with the tail connecting to the
	 * node # given as the first argument.
	 * 
	 * @param pointOfConnect
	 *            the # of the node (starts from 0) at which the last node
	 *            connects back to the list
	 * @param values
	 *            the values for each node in the list in order
	 * @return returns the head pointer
	 */
	public ListNode createCyclicLinkedList(int pointOfConnect,
			Integer... values) {
		if (pointOfConnect >= values.length - 1) {
			System.out
					.println("Not a valid pointOfConnect given as the first argument. Can only be in the range [0, values.length-1]");
			return null;
		}
		firstNode = new ListNode(values[0]);
		for (int i = 1; i < values.length; ++i)
			insert(values[i]);
		ListNode temp = firstNode, connectingNode = null;
		for (int i = 0; i < pointOfConnect; ++i) {
			temp = temp.next;
		}
		connectingNode = temp;

		temp = firstNode;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = connectingNode;
		return firstNode;
	}

	public boolean insert(int n) {
		ListNode temp = firstNode;
		while (temp.next != null) {
			temp = temp.next;
		}
		ListNode newNode = new ListNode(0);
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

	public void printNNodes(ListNode node, int N) {
		int count = 0;
		while (node != null && count < N) {
			System.out.print(node.val + " -> ");
			node = node.next;
			count++;
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
		if (node == null || node.next == null) {
			return node;
		}
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
		i--;
		j--;
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
		if (curr == null)
			return prev;
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
			ListNode newNode = new ListNode(0);
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
			ListNode newNode = new ListNode(0);
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
				ListNode newNode = new ListNode(0);
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

	public ListNode addTwoNumbers(ListNode a, ListNode b) {
		ListNode ta = a, tb = b;
		int carry = 0;

		ListNode latest = new ListNode(0);
		latest.next = null;
		String sum = String.valueOf(ta.val + tb.val + carry);
		if (sum.length() == 1) {
			latest.val = Integer.valueOf(sum);
		} else {
			latest.val = Integer.valueOf("" + sum.charAt(1));
			carry = Integer.valueOf("" + sum.charAt(0));
		}
		ListNode head = latest;
		ta = ta.next;
		tb = tb.next;

		while (!(ta == null && tb == null)) {
			ListNode node = new ListNode(0);
			latest.next = node;
			latest = node;
			node.next = null;
			if (ta != null && tb != null)
				sum = String.valueOf(ta.val + tb.val + carry);
			else if (ta == null)
				sum = String.valueOf(tb.val + carry);
			else if (tb == null)
				sum = String.valueOf(ta.val + carry);
			carry = 0;
			if (sum.length() == 1) {
				node.val = Integer.valueOf(sum);
			} else {
				node.val = Integer.valueOf("" + sum.charAt(1));
				carry = Integer.valueOf("" + sum.charAt(0));
			}
			if (ta != null)
				ta = ta.next;
			if (tb != null)
				tb = tb.next;
		}
		if (carry != 0) {
			ListNode node = new ListNode(0);
			latest.next = node;
			latest = node;
			node.next = null;
			node.val = carry;
		}
		return head;
	}

	// Given 1-2-2-3-4-4-5, returns 1-3-5
	// Kind of messy. Method2 is clean(er)
	public ListNode removeDuplicatesFromSortedList2Method1(ListNode node) {
		ListNode head = node;
		ListNode temp = node;
		ListNode prev = node;
		boolean flag = false;
		while (head.next != null && head.val == head.next.val) {
			flag = true;
			head = temp = prev = head.next;
			if (head.next != null && head.val != head.next.val) {
				flag = false;
				head = temp = prev = head.next;
			}
		}
		if (flag == true) {
			flag = false;
			head = temp = prev = head.next;
		}
		while (temp != null) {
			while (temp.next != null && temp.val == temp.next.val) {
				flag = true;
				temp.next = temp.next.next;
			}
			if (flag) {
				prev.next = temp.next;
				flag = false;
			} else {
				prev = temp;
			}
			temp = temp.next;
		}
		return head;
	}

	// Given 1-2-2-3-4-4-5, returns 1-3-5
	public ListNode removeDuplicatesFromSortedList2Method2(ListNode node) {
		ListNode head = node;
		ListNode temp = node;
		while (head.next != null && head.val == head.next.val) {
			head = temp = head.next;
			if (head.next != null && head.val != head.next.val) {
				head = temp = head.next;
			} else if (head.next == null) {
				return null;
			}
		}
		while (temp != null) {
			if (temp.next != null && temp.next.next != null
					&& temp.next.val == temp.next.next.val) {
				while (temp.next != null && temp.next.next != null
						&& temp.next.val == temp.next.next.val) {
					temp.next = temp.next.next;
				}
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
		return head;
	}

	// List reordered to L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → ...
	// Does it in O(n^2)
	public ListNode reorderList(ListNode node) {
		if (node == null)
			return null;
		ListNode head = node;
		ListNode c = head, a = head.next;
		ListNode temp1 = null, temp2 = null;
		if (a == null)
			return head;
		while (a != temp2) {
			temp1 = a;
			temp2 = c;
			while (temp1.next != null) {
				temp2 = temp1;
				temp1 = temp1.next;
			}
			if (temp2.next == a) {
				break;
			}
			// Make new links
			c.next = temp1;
			temp2.next = null;
			temp1.next = a;
			// Move pointers
			c = a;
			a = a.next;
			if (a == null)
				break;
			if (a.next == temp2) {
				c.next = temp2;
				temp2.next = a;
				a.next = null;
				break;
			}
		}
		return head;
	}

	// List reordered to L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → ...
	// Does it in O(n) - O(n) to reverse second half, O(n) to intertwine the
	// links
	public ListNode reorderList2(ListNode node) {
		if (node == null || node.next == null)
			return node;
		node = reverseSecondHalf(node);
		ListNode head = node;
		ListNode slow = node;
		ListNode fast = node;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode l1 = head;
		ListNode l2 = head.next;
		ListNode r1 = slow.next;
		ListNode r2 = r1.next;
		while (r1 != null) {
			l1.next = r1;
			r1.next = l2;
			if (r2 == null) {
				if (l2.next == slow.next) {
					l2.next = null;
				} else {
					r1.next = null;
				}
				break;
			}
			// Move pointers
			l1 = l2;
			l2 = l2.next;
			r1 = r2;
			r2 = r2.next;
		}
		return head;
	}

	public ListNode getCycleStartNode(ListNode a) {
		if (a == null || a.next == null)
			return null;

		ListNode fast = a, slow = a, slow2 = a;
		while (true) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow)
				break;
			if (fast == null)
				return null;
			if (fast.next == null)
				return null;
		}
		while (slow2 != fast) {
			slow2 = slow2.next;
			fast = fast.next;
		}
		return slow2;
	}
}