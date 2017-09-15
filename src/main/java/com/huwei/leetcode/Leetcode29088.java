package com.huwei.leetcode;

/**
 * A message containing letters fromA-Zis being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message"12", it could be decoded as"AB"(1 2) or"L"(12).
 * The number of ways decoding"12"is 2.
 */
public class Leetcode29088 {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        char[] c = s.toCharArray();

        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = isValide(c[0]) ? 1 : 0;

        for (int i = 2; i <= len; i++) {
            dp[i] = (isValide(c[i-1]) ? dp[i - 1] : 0) + (isValide(c[i - 2], c[i-1]) ? dp[i - 2] : 0);
        }
        return dp[len];
    }

    private boolean isValide(char a) {
        int value = a - '0';
        return value > 0 && value < 10;
    }

    private boolean isValide(char a, char b) {
        int value = (a - '0') * 10 + (b - '0');
        return value >= 10 && value <= 26;
    }
}
