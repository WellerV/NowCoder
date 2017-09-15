package com.huwei.leetcode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given1->2->3->4->5->NULL, m = 2 and n = 4,
 * return1->4->3->2->5->NULL.
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
public class Leetcode29086 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode sHead = new ListNode(0);
        sHead.next = head;
        ListNode p = head;
        ListNode preStart = sHead;

        for (int i = 1; i < m; i++) {
            preStart = p;
            p = p.next;
        }

        for (int i = 0; i < n - m; i++) {
            ListNode next = p.next;
            p.next = next.next;
            next.next = preStart.next;
            preStart.next = next;
        }

        return sHead.next;
    }
}
