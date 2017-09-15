package com.huwei.leetcode;

import java.util.ArrayList;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return[0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example,[0,2,3,1]is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
public class Leetcode29089 {
    public ArrayList<Integer> grayCode(int n) {
        if (n == 0) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        ArrayList<Integer> dp[] = new ArrayList[n];
        dp[0] = new ArrayList<>();
        dp[0].add(0);
        dp[0].add(1);
        for (int i = 1; i < n; i++) {
            dp[i] = new ArrayList<>();
            //+0 高位
            dp[i].addAll(dp[i - 1]);
            //+1　高位
            for (int j = dp[i - 1].size() - 1; j >= 0; j--) {
                dp[i].add(dp[i - 1].get(j) | (int) Math.pow(2, i));
            }
        }
        return dp[n - 1];
    }
}
