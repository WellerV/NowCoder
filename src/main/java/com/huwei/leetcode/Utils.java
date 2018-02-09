package com.huwei.leetcode;

/**
 * Created by huwei on 17-10-30.
 */
public class Utils {
    public static ListNode createFromArray(int[] array) {
        if (array.length < 1) return null;
        ListNode head = new ListNode(array[0]);
        ListNode p = head;
        for (int i = 1; i < array.length; i++) {
            p.next = new ListNode(array[i]);
            p = p.next;
        }
        return head;
    }
}
