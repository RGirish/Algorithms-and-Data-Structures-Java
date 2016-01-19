
Node SortedInsert(Node head, int data) {
    if (head == null) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.prev = null;
        newNode.next = null;
        return head;
    }
    Node temp = head;
    while (temp != null) {
        if (temp.data >= data || temp.next == null) break;
        temp = temp.next;
    }
    
    Node newNode = new Node();
    newNode.data = data;
    if (temp.next == null && temp.data <= data) {
        // newNode is the last node
        newNode.prev = temp;
        newNode.next = null;
        temp.next = newNode;
    } else if (temp.prev == null) {
        // newNode is the first node
        newNode.prev = null;
        newNode.next = temp;
        temp.prev = newNode;
    } else {
        // newNode is in the middle
        temp.prev.next = newNode;
        newNode.prev = temp.prev;
        newNode.next = temp;
        temp.prev = newNode;
    }
    return head;
}
