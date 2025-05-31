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
    ListNode head;
    Random ram;

    public Solution(ListNode head) {
        this.head = head;
        this.ram = new Random();

    }

    public int getRandom() {
        ListNode curr = head;
        int result = curr.val;
        int i = 1;
        while (curr != null) {
            if (ram.nextInt(i) == 0) {
                result = curr.val;
            }
            curr = curr.next;
            i++;
        }
        return result;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */