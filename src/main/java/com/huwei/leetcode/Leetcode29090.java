package com.huwei.leetcode;

import java.util.Arrays;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 */
public class Leetcode29090 {
    public void merge(int A[], int m, int B[], int n) {
        int C[] = Arrays.copyOf(A, m);
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (C[i] < B[j]) {
                A[k] = C[i];
                i++;
            } else {
                A[k] = B[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            A[k] = C[i];
            i++;
            k++;
        }

        while (j < n) {
            A[k] = B[j];
            j++;
            k++;
        }
    }
}
