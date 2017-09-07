package com.huwei.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree{3,9,20,#,#,15,7},
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * return its bottom-up level order traversal as:
 * [
 * [15,7]
 * [9,20],
 * [3],
 * ]
 * <p>
 * confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.
 * <p>
 * OJ's Binary Tree Serialization:
 * The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
 * Here's an example:
 * 1
 * / \
 * 2   3
 * /
 * 4
 * \
 * 5
 * The above binary tree is serialized as"{1,2,3,#,#,4,#,#,5}".
 */
public class Leetcode29071 {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                arrayList.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            resultList.add(0, arrayList);
        }
        return resultList;
    }
}
