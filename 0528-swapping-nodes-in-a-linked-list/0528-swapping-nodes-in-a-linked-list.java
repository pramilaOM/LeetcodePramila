/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {

        ListNode node1 = null;
        ListNode node2 = null;
        ListNode temp = head;
        while (temp != null) {
            k--;
            if (node2 != null) {
                node2 = node2.next;
            }

            if (k == 0) {
                node1 = temp;
                node2 = head;
            }
            temp = temp.next;
        }

        int swap = node1.val;
        node1.val = node2.val;
        node2.val = swap;
        return head;

    }

}
