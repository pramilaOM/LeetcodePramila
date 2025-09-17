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

        ListNode smallPtr = small;
        ListNode largePtr = large;

        while (head != null) {

            if (head.val < x) {
                smallPtr.next = head;
                smallPtr = smallPtr.next;
            } else {
                largePtr.next = head;
                largePtr = largePtr.next;
            }
            head = head.next;
        }

        smallPtr.next = large.next;
        largePtr.next = null;

        return small.next;
    }
}