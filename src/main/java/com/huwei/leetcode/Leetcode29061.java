package com.huwei.leetcode;

import java.util.ArrayList;


/**
 * Given an index k, return the k th row of the Pascal's triangle.
 * For example, given k = 3,
 * Return[1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class Leetcode29061 {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<>(rowIndex + 1);
        init(list, rowIndex + 1);
        for (int i = 0; i < rowIndex + 1; i++) {
            for (int j = 0; j < rowIndex + 1; j++) {
                if (j == 0 || j == rowIndex) {
                    list.set(j, 1);
                } else {
                    list.set(j, get(list, j - 1) + get(list, j));
                }
            }
        }
        return list;
    }

    private void init(ArrayList<Integer> list, int n) {
        for (int i = 0; i < n; i++)
            list.add(0);
    }

    private int get(ArrayList<Integer> list, int index) {
        return list.get(index) == null ? 0 : list.get(index);
    }

    private ArrayList<Integer> lowHandle(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<>();
        int len = rowIndex + 1;
        for (int i = 0; i <= rowIndex / 2; i++) {
            int val = factorial(rowIndex - i + 1, rowIndex) / factorial(1, i);
            if (len % 2 != 0 && i == len / 2) {
                list.add(i, val);
            } else {
                list.add(i, val);
                list.add(i + 1, val);
            }
        }
        return list;
    }

    private int factorial(int i, int n) {
        int s = 1;
        for (; i <= n; i++) {
            s *= i;
        }
        return s;
    }
}
