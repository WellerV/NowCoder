package com.huwei.leetcode;

import java.util.ArrayList;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree andsum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class Leetcode29066 {
    private ArrayList<ArrayList<Integer>> mResult = new ArrayList<>();
    private ArrayList<Integer> mCurList = new ArrayList<>();
    private int mTargetSum;

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        mResult.clear();
        mCurList.clear();
        mTargetSum = sum;
        travel(root, 0, 0);
        return mResult;
    }

    private void travel(TreeNode node, int sum, int floor) {
        if (node != null) {
            //visit
            mCurList.add(node.val);
            sum += node.val;

            if (isLeaf(node)) {
                if (mTargetSum == sum) mResult.add(mCurList);
            } else {

                if (node.left != null) {
                    travel(node.left, sum, floor + 1);
                }

                mCurList = new ArrayList<Integer>(mCurList.subList(0, floor + 1));

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
