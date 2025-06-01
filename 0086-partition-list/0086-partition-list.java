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
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);

        ListNode smallPointer = small;
        ListNode largePointer = large;

        while (head != null) {
            if (head.val < x) {
                smallPointer.next = head;
                smallPointer = smallPointer.next;
            } else {
                largePointer.next = head;
                largePointer = largePointer.next;
            }
            head = head.next;
        }

        smallPointer.next = large.next;
        largePointer.next = null;

        return small.next;

    }
}