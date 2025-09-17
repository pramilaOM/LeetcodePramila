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
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        ListNode it = head;
        ListNode prev = dummy;

        while (it != null && it.next != null) {
            boolean foundDuplication = false;
            while (it != null && it.next != null && it.val == it.next.val) {
                foundDuplication = true;
                it = it.next;
            }

            if (!foundDuplication) {
                prev = prev.next;
            } else {
                prev.next = it.next;
            }

            it = it.next;
        }
        return dummy.next;

    }
}