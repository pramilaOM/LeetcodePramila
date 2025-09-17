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

//https://www.youtube.com/watch?v=QxevnZTKvXc
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int length = getListLength(head);

        if (length <= 1 || k == 0 || k % length == 0) {
            return head;
        }
        if (k > length) {
            k = k % length;
        }

        int breakagePoint = length - k;
        ListNode temp = head;
        ListNode prev = null;
        while (breakagePoint > 0 && temp != null) {
            prev = temp;
            temp = temp.next;
            breakagePoint--;
        }
        prev.next = null;
        ListNode iterator = temp;
        if (iterator != null) {
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = head;
        }
        return temp;
    }

    int getListLength(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
}