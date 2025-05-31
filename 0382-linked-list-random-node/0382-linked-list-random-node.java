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
    List<Integer> values = new ArrayList<>();
    Random ram = new Random();

    public Solution(ListNode head) {
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

    }

    public int getRandom() {
        int len = values.size();
        int index = ram.nextInt(len);
        return values.get(index);

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */