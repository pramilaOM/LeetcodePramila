/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return head;
        }
        Node current = head;

        while (current != null) {
            Node currNext = current.next;
            current.next = new Node(current.val);
            current.next.next = currNext;
            current = currNext;
        }
        current = head;
        while (current != null && current.next != null) {
            if (current.random == null) {
                current.next.random = null;
            } else {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        Node newHead = head.next;
        Node newCurr = newHead;

        current = head;

        while (current != null && newCurr != null) {
            current.next = (current.next != null) ? current.next.next : null;
            newCurr.next = (newCurr.next != null) ? newCurr.next.next : null;

            current = current.next;
            newCurr = newCurr.next;

        }
        return newHead;

    }
}