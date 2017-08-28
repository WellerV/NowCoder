package com.huwei.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * <p>
 * The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */

/**
 * 整个三角形可以看做一个二叉树，用f表示二叉树深度，从1到n。
 * 二维ArrayList<ArrayList<Integer>> 可以看做是一个一维数组，其中index表示数组的游标，从0到len-1。
 * 左孩子就是当前节点加上这层孩子的数目f，也就是index+f
 * len是一维数组，也可以用来约束一维数组的index是否越界，换句话，就是可以判断叶子节点。
 *
 */
public class Leetcode29060 {
    int len;

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        len = triangle.size() * (triangle.size() + 1) / 2;
        return minSum(triangle, 0, 1);
    }

    /**
     *  用来表示某棵树的路径最小的节点之和，无非两种情况，选择左树或者右树
     */
    private int minSum(ArrayList<ArrayList<Integer>> triangle, int index, int f) {
        if (index >= len) return 0;
        int leftVal = minSum(triangle, index + f, f + 1);   //左树的最小路径节点和
        int rightVal = minSum(triangle, index + f + 1, f + 1);  //右树的最小路径节点和

        List<Integer> list = triangle.get(f - 1);   //获取层  数组
        int val = list.get(index - (f - 1) * f / 2);  //换算出在当前数组的位置，根据1...n的连续和公式，前f-1层一共有 (f-1)*f/2个节点

        return Math.min(leftVal + val, rightVal + val);
    }
}
