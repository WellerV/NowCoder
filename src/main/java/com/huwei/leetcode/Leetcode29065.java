package com.huwei.leetcode;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie,"ACE"is a subsequence of"ABCDE"while"AEC"is not).
 * Here is an example:
 * S ="rabbbit", T ="rabbit"
 * Return3.
 */

/**
 * 解法：
 * dp[i][j] 表示T中0-i的 是 T中0-j的子序列的个数
 * <p>
 * 分两种情况
 * 1，如果T[i] = S[j], dp[i][j] = dp[i-i][j-1](包含s[j]) + dp[i][j-1] (不包含s[j])
 * 2,如果T[i] != S[j], dp[i][j] = dp[i][j-1]
 */
public class Leetcode29065 {
    public int numDistinct(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int lenS = S.length();
        int lenT = T.length();
        if (lenS == 0 || lenT == 0) return 0;
        int dp[][] = new int[lenT][lenS];
        dp[0][0] = t[0] == s[0] ? 1 : 0;
        for (int j = 1; j < lenS; j++)
            dp[0][j] = t[0] == s[j] ? dp[0][j - 1] + 1 : dp[0][j - 1];
        for (int i = 1; i < lenT; i++) {
            for (int j = 1; j < lenS; j++) {
                if (t[i] == s[j]) dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                else dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[lenT - 1][lenS - 1];
    }
}
