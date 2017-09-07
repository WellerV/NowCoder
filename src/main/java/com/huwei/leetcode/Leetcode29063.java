package com.huwei.leetcode;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note:
 * You may only use constant extra space.
 * <p>
 * For example,
 * Given the following binary tree,
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * <p>
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \    \
 * 4-> 5 -> 7 -> NULL
 * <p>
 * <p>
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 * int val;
 * TreeLinkNode left, right, next;
 * TreeLinkNode(int x) { val = x; }
 * }
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 * int val;
 * TreeLinkNode left, right, next;
 * TreeLinkNode(int x) { val = x; }
 * }
 */
public class Leetcode29063 {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeLinkNode preNode = queue.peek();
            handleChild(preNode, queue);
            for (int i = 1; i < queue.size(); i++) {
                preNode.next = queue.poll();
                preNode = preNode.next;
                handleChild(preNode, queue);
            }
        }
    }

    private void handleChild(TreeLinkNode node, Queue queue) {
        if (node == null) return;
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
    }
}