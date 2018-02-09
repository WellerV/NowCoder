package com.huwei.leetcode;

/**
 * Created by huwei on 17-10-30.
 */
public class Leetcode29092 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode s = new ListNode(0);
        s.next = head;
        ListNode q = head, p = s, anchor = null;
        while (q != null) {
            if (q.val >= x) {
                anchor = p;

                p = q;
                q = q.next;
                break;
            }
            p = q;
            q = q.next;
        }

        while (q!=null) {
            if (q.val < x) {
                p.next = q.next;
                q.next = anchor.next;
                anchor.next = q;

                anchor = q;
                q = p.next;
            } else {
                p = q;
                q = p.next;
            }
        }

        return s.next;
    }
}
