package com.huwei.leetcode;

/**
 * Created by huwei on 17-8-24.
 */
public class Leetcode29051 {

    int sum;

    public int sumNumbers(TreeNode root) {
        sum = 0;
        travel(root, 0);
        return sum;
    }

    private void travel(TreeNode node, int d) {
        if (node != null) {
            d = d * 10 + node.val;
            if (isLeaf(node)) {
                sum += d;
            } else {
                travel(node.left, d);
                travel(node.right, d);
            }
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
