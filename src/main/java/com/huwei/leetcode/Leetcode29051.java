package com.huwei.leetcode;

/**
 * Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path1->2->3which represents the number123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 * 1
 * / \
 * 2   3
 * <p>
 * The root-to-leaf path1->2represents the number12.
 * The root-to-leaf path1->3represents the number13.
 * Return the sum = 12 + 13 =25.
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
