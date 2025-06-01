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
        Stack<Integer> value = new Stack<>();
        ListNode curr = head;

        while (curr != null) {
            value.push(curr.val);
            curr = curr.next;

        }

        int n = value.size();
        int count = 1;
        curr = head;
        int result = 0;
        while (count <= n / 2) {
            result = Math.max(result, curr.val + value.peek());
            curr = curr.next;
            value.pop();
            count++;
        }

        return result;

    }
}