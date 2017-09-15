package com.huwei.leetcode;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 ="aabcc",
 * s2 ="dbbca",
 * When s3 ="aadbbcbcac", return true.
 * When s3 ="aadbbbaccc", return false.
 */
public class Leetcode29081 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int c1Len = s1.length();
        int c2Len = s2.length();
        int c3Len = s3.length();

        if (c1Len + c2Len != c3Len) return false;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();

        boolean[][] dp = new boolean[c1Len + 1][c2Len + 1];
        dp[0][0] = true;
        //从s1中取出0个
        for (int i = 1; i <= c2Len; i++) {
            dp[0][i] = dp[0][i - 1] && c2[i - 1] == c3[i - 1];
        }
        //从s2中取出0个
        for (int i = 1; i <= c1Len; i++) {
            dp[i][0] = dp[i - 1][0] && c1[i - 1] == c3[i - 1];
        }
        for (int i = 1; i <= c1Len; i++) {
            for (int j = 1; j <= c2Len; j++) {
                dp[i][j] = (c1[i - 1] == c3[i + j - 1] && dp[i - 1][j]) || (c2[j - 1] == c3[i + j - 1] && dp[i][j - 1]);
            }
        }
        return dp[c1Len][c2Len];
    }
}
