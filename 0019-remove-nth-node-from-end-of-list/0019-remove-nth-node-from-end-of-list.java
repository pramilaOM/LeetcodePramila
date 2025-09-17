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
    //2 pass
    private int lengthLinkedList(ListNode head) {
        int l = 0;
        while (head != null) {
            l++;
            head = head.next;
        }
        return l;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = lengthLinkedList(head);

        if (length == n) {
            ListNode temp = head.next;
            head = null;
            return temp;
        }

        ListNode temp = head;
        ListNode prev = null;
        int travel = length - n;

        while (travel-- > 0) {
            prev = temp;
            temp = temp.next;
        }

        if (prev != null) {
            prev.next = temp.next;
        }

        temp = null;
        return head;

    }
}