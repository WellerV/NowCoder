package com.huwei.leetcode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * For example:
 * Given the below binary tree andsum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path5->4->11->2which sum is 22.
 */
public class Leetcode29067 {
    private int mTargetSum;
    private boolean mHasPathSum;

    public boolean hasPathSum(TreeNode root, int sum) {
        mTargetSum = sum;
        travel(root, 0, 0);
        return mHasPathSum;
    }

    private void travel(TreeNode node, int sum, int floor) {
        if (node != null && !mHasPathSum) {
            //visit
            sum += node.val;

            if (isLeaf(node)) {
                if (mTargetSum == sum) {
                    mHasPathSum = true;
                }
            } else {
                if (node.left != null) {
                    travel(node.left, sum, floor + 1);
                }

                if (node.right != null) {
                    travel(node.right, sum, floor + 1);
                }
            }
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
