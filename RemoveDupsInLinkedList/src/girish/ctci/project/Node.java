package girish.ctci.project;

public class Node {

	Node next;
	int i;
	
	Node(int i){
		this.i = i;
	}
	
	public void appendToTail(int i){
		Node newNode = new Node(i);
		newNode.next = null;
		Node n = this;
		while(n.next != null){
			n = n.next;
		}
		n.next = newNode;
	}
	
	public Node deleteNode(Node head, int i){
		Node n = head;
		if(n.i == i){
			return n.next;
		}
		while(n.next != null){
			if(n.next.i == i){
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}
	
}
