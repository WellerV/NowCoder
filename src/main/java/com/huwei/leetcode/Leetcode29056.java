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
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxSum(root);
        return max;
    }

    /**
     * 以node为start的最大和
     * @param node
     * @return
     */
    private int maxSum(TreeNode node) {
        if (node == null) return 0;
        int leftSum = maxSum(node.left);  //求左支路
        int rightSum = maxSum(node.right);  //求右支路

        //经过node的最大和  为root,root + left,root+right,root+left+right中的一种情况
        int current = node.val;
        if (leftSum > 0) {
            current += leftSum;
        }

        if (rightSum > 0) {
            current += rightSum;
        }

        max = Math.min(max, current);
        return Math.max(node.val, Math.max(node.val + leftSum, node.val + rightSum));
    }
}
