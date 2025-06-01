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
        ArrayList<Integer> data = new ArrayList<>();

        while (head != null) {
            data.add(head.val);
            head = head.next;
        }
        int i = 0;
        int j = data.size() - 1;
        int max = 0;
        while (i < j) {
            if (max < data.get(i) + data.get(j)) {
                max = data.get(i) + data.get(j);
            }
            i++;
            j--;
        }

        return max;

    }
}