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
        Map<Node, Node> data = new HashMap<>();
        Node current = head;
        Node newHead = null;
        Node prev = null;

        while (current != null) {
            Node temp = new Node(current.val);
            data.put(current, temp);
            if (newHead == null) {
                newHead = temp;
                prev = newHead;
            } else {
                prev.next = temp;
                prev = temp;
            }
            current = current.next;
        }
        // for random pointer
        current = head;
        Node newCurr = newHead;
        while (current != null) {

            if (current.random == null) {
                newCurr.random = null;
            } else {
                newCurr.random = data.get(current.random);
            }
            newCurr = newCurr.next;
            current = current.next;
        }

        return newHead;

    }
}