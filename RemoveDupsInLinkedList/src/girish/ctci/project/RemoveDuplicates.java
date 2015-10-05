package girish.ctci.project;

public class RemoveDuplicates {
	
	public static void main(String[] args){
		Node head = new Node(10);
		for(int i=20 ; i<=100 ; i=i+10){
			head.appendToTail(i);
		}
		Node n = head;
		while(n!=null){
			System.out.println(n.i);
			n = n.next;
		}
	}
	
}