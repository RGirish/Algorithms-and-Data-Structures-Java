public class ListNode {
	int val;
	ListNode next;

	public void setValue(int n) {
		this.val = n;
	}

	public void setNextNode(ListNode node) {
		this.next = node;
	}

	ListNode(int x) {
		val = x;
		next = null;
	}

	ListNode() {
	}
}