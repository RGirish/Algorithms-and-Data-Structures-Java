/*
  Get Nth element from the end in a linked list of integers
  Number of elements in the list will always be greater than N.
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
    
int GetNode(Node head, int n) {
    String s = GetNodeString (head, n);
    String[] parts = s.split(" ");
    return Integer.parseInt(parts[1]);
}

String GetNodeString (Node head, int n) {
    if (head == null) return "0";
    else {
        String s = GetNodeString(head.next, n);
        if ( s.startsWith("found") ) {
            return s;
        }
        int k = Integer.parseInt(s);
        if (k == n) {
            return "found " + head.data;
        }
        return String.valueOf(k + 1);
    }
}