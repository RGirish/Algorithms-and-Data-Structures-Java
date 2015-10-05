package girish.ctci.project;

public class RemoveDuplicates {
	
	static Node head;
	
	public static void main(String[] args){
		addValuesToLinkedList();
		printLinkedList();
		
		head.deleteDups(head);
		System.out.println("After Deletion of Duplicates:");
		printLinkedList();
	}
	
	public static void addValuesToLinkedList(){
		head = new Node(1);
		head.appendToTail(2);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(5);
		head.appendToTail(3);
	}
	
	public static void printLinkedList(){
		Node n = head;
		while(n!=null){
			System.out.println(n.i);
			n = n.next;
		}
	}
	
}