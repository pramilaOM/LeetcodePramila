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
    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        int eachBucket = count / k;
        int remainder = count % k;

        ListNode[] result = new ListNode[k];

        curr = head;
        ListNode prev = null;

        for (int i = 0; curr != null && i < k; i++) {
            result[i] = curr;
            for (int ctr = 1; ctr <= eachBucket + (remainder > 0 ? 1 : 0); ctr++) {
                prev = curr;
                curr = curr.next;
            }
            if (prev != null) {
                prev.next = null;
            }
            remainder--;
        }

        return result;
    }
}