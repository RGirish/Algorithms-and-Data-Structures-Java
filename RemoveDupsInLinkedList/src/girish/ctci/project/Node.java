package girish.ctci.project;

import java.util.ArrayList;

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
	
	public Node deleteFirstOccurance(Node head, int i){
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
	
	public void deleteDups(Node node){
		Node previous = null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(node != null){
			if(list.contains(node.i)){
				previous.next = node.next;
			}else{
				list.add(node.i);
				previous = node;
			}
			node = node.next;
		}
	}
	
}
