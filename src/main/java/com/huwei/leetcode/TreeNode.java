package com.huwei.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
Created by huwei on 17-8-24.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    private static List<TreeNode> nodeList = new ArrayList<>();

    public static TreeNode create(int array[]) {
        nodeList.clear();
        for (int i = 0; i < array.length; i++) {
            nodeList.add(new TreeNode(array[i]));
        }

        if (nodeList.size() > 0) {
            for (int y = 0; y < array.length / 2 - 1; y++) {
                //leftChild  
                if (null != nodeList.get(2 * y + 1)) {
                    nodeList.get(y).left = nodeList.get(2 * y + 1);
                }
                //rightChild  
                if (null != nodeList.get(2 * y + 2)) {
                    nodeList.get(y).right = nodeList.get(2 * y + 2);
                }
            }
            //最后一个父节点不一定有孩子  
            int lastParentIndex = array.length / 2 - 1;
            // 左孩子  
            nodeList.get(lastParentIndex).left = nodeList
                    .get(lastParentIndex * 2 + 1);
            //奇数时候有右孩子  
            if (array.length % 2 == 1) {
                nodeList.get(lastParentIndex).right = nodeList
                        .get(lastParentIndex * 2 + 2);
            }
        }
        return nodeList.isEmpty() ? null : nodeList.get(0);
    }
}
