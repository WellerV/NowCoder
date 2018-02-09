package com.huwei.leetcode;

/**
 * Created by huwei on 17-9-13.
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(val);
        ListNode p = next;

        while (p != null) {
            stringBuilder.append("->");
            stringBuilder.append(p.val);

            p = p.next;
        }
        return stringBuilder.toString();
    }
}
