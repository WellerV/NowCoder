package com.huwei.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If S =[1,2,2], a solution is:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class Leetcode29087 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Arrays.sort(num);
        backtrace(list, new ArrayList<Integer>(), num, 0);
        return list;
    }

    private void backtrace(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> tmpList, int[] num, int start) {
        list.add(new ArrayList<Integer>(tmpList));
        for (int i = start; i < num.length; i++) {
            if (i > start && num[i] == num[i - 1]) continue;
            tmpList.add(num[i]);
            backtrace(list, tmpList, num, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
