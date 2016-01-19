/*
  Reverse a linked list and return pointer to the head
  The input list will have at least one element  
  Node is defined as  
  class Node {
     int data;
     Node next;
  }
*/
    // This is a "method-only" submission. 
    // You only need to complete this method. 
Node Reverse(Node head) {
    if (head == null || head.next == null){
        return head;
    } else if (head.next.next == null) {
        Node two = head.next;
        two.next = head;
        head.next = null;
        return two;
    } else {
        Node previous = head;
        Node previousAhead = previous.next;
        Node current = previousAhead;
        Node currentAhead = current.next;
        int count = 0;
        while (true) {
            previousAhead.next = previous;
            if(count == 0) {
                previous.next = null;
                count++;
            }
            current = currentAhead;
            if(current == null) break;
            currentAhead = current.next;
            previous = previousAhead;
            previousAhead = current;
        }
        return previousAhead;
    }
}
