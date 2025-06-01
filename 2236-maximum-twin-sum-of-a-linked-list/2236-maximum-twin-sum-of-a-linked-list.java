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
    public int pairSum(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;
        ListNode prev = null;
        ListNode nextNode = null;
        while (mid != null) {
            nextNode = mid.next;
            mid.next = prev;
            prev = mid;
            mid = nextNode;
        }

        int result = 0;
        ListNode curr = head;

        while (prev != null) {
            result = Math.max(result, curr.val + prev.val);
            curr = curr.next;
            prev = prev.next;
        }

        return result;

    }
}