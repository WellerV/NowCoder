package com.huwei.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given[100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
 * Your algorithm should run in O(n) complexity.
 */
public class Leetcode29052 {
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<>();
        for (Integer n : num) {
            set.add(n);
        }

        int max = 1;
        for (int n : num) {
            if (set.remove(n)) {
                int val = n;
                int pre = val - 1;
                int next = val + 1;
                int sum = 1;
                while (set.remove(pre)) {
                    pre--;
                    sum++;
                }

                while (set.remove(next)) {
                    next++;
                    sum++;
                }

                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
