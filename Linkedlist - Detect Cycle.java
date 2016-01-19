/*
  Detect cycle in the list
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
int HasCycle(Node head) {
    Node slowRunner = head;
    Node fastRunner = head;
    while(fastRunner != null && slowRunner != null) {
        fastRunner = fastRunner.next.next;
        slowRunner = slowRunner.next;
        if(fastRunner == slowRunner) {
            return 1;
        }
    }
    return 0;
}
