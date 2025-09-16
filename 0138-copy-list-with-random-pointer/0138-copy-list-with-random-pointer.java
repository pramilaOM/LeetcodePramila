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
        if (head == null)
            return null;

        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next;
            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = nextNode;
            curr = nextNode;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node newHead = head.next;
        curr = head;
        Node newCurr = newHead;

        while (curr != null) {
            curr.next = curr.next.next;
            newCurr.next = (newCurr.next != null) ? newCurr.next.next : null;
            curr = curr.next;
            newCurr = newCurr.next;

        }
        return newHead;
    }
}