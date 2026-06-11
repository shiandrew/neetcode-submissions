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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        
        for (ListNode curr = head; curr != null; curr = curr.next) {
            len++;
        }

        int m = len - n;

        if (m == 0) {
            return head.next;
        }

        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i <= m; i++) {
            if (i == m) {
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
