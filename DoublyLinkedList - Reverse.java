Node Reverse(Node head) {
    Node temp = head;
    while (temp != null) {
        Node n = temp.next;
        temp.next = temp.prev;
        temp.prev = n;
        if(temp.prev == null) {
            return temp;
        }
        temp = temp.prev;
    }
    return null;
}