package com.huwei.leetcode;

/**
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * For example:
 * Given the below binary tree,
 * 1
 * / \
 * 2   3
 * <p>
 * Return6.
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Leetcode29056 {
    int sum;

    public int maxPathSum(TreeNode root) {
        sum = 0;
        travel(root, -Integer.MAX_VALUE);
        return sum;
    }

    private void travel(TreeNode node, int m) {
        if (node != null) {
            m = Math.max(m, node.val);

            if (isLeaf(node)) sum += m;

            travel(node.left, m);
            travel(node.right, m);
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
