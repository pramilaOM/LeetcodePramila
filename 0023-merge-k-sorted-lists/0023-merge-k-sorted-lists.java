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
    public ListNode mergeTwoSortedLists(ListNode lists1, ListNode lists2) {
        if (lists1 == null) {
            return lists2;
        }

        if (lists2 == null) {
            return lists1;
        }

        if (lists1.val <= lists2.val) {
            lists1.next = mergeTwoSortedLists(lists1.next, lists2);
            return lists1;
        } else {
            lists2.next = mergeTwoSortedLists(lists1, lists2.next);
            return lists2;
        }

    }

    public ListNode partitionAndMerge(int start, int end, ListNode[] lists) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;

        ListNode L1 = partitionAndMerge(start, mid, lists);
        ListNode L2 = partitionAndMerge(mid + 1, end, lists);

        return mergeTwoSortedLists(L1, L2);

    }

    public ListNode mergeKLists(ListNode[] lists) {

        int size = lists.length;
        if (size == 0) {
            return null;
        }

        return partitionAndMerge(0, size - 1, lists);

    }
}