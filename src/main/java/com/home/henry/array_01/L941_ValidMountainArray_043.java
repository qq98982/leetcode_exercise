package com.home.henry.array_01;

/**
 * 941. Valid Mountain Array
 *
 * 思路: Two people climb from left and from right separately.
 * If they are climbing the same mountain,
 * they will meet at the same point.
 *
 * 要考虑第一个数就比后面大的情况
 * 下面是比较简洁的做法, 值得学习
 */
public class L941_ValidMountainArray_043 {

    static class SolutionClean {
        public boolean validMountainArray(int[] A) {
            if (A == null || A.length < 3) {return false;}
            int n = A.length, i = 0, j = n - 1;
            while (i < n - 1 && A[i] < A[i + 1]) {i++;}
            while (j > 0 && A[j - 1] > A[j]) {j--;}
            return i > 0 && j < n - 1 && i == j;
        }
    }

    static class Solution {
        public boolean validMountainArray(int[] A) {
            if (A == null || A.length < 3) {return false;}
            boolean peekReached = false;
            for (int i = 1; i < A.length - 1; i++) {
                if (A[i - 1] > A[i]) {
                    peekReached = true;
                }
                if (peekReached) {
                    if (A[i - 1] > A[i]) {
                        return false;
                    }
                }
                if (A[i] > A[i - 1] && A[i + 1] < A[i]) {
                    for (int j = i + 1; j < A.length - 1; j++) {
                        if (A[j] <= A[j + 1]) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
    }

}
