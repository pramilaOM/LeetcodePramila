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
    public ListNode swapNodes(ListNode head, int k) {

                    int size = findSize(head);
            int k1 = k;
            ListNode node1 = head;
            while (k1 > 1) {
                node1 = node1.next;
                k1--;
            }

            int k2 = size - k + 1;
            ListNode node2 = head;
            while (k2 > 1) {
                node2 = node2.next;
                k2--;
            }

            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
            return head;
        
    }
    public static int findSize(ListNode head) {
            int count = 0;
            while (head != null) {
                count++;
                head = head.next;
            }

            return count;

        }
}