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

        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        Node newHead = null;
        Node prev = null;

        while (curr != null) {
            Node temp = new Node(curr.val);
            map.put(curr, temp);

            if (newHead == null) {
                newHead = temp;
            } else {
                prev.next = temp;
            }
            prev = temp;
            curr = curr.next;

        }

        curr = head;
        Node newCurr = newHead;
        while (curr != null) {
            newCurr.random = map.get(curr.random);
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }
}