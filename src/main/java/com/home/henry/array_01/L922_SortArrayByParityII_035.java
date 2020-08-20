package com.home.henry.array_01;

import java.util.Arrays;

/**
 * 922. Sort Array By Parity II
 */
public class L922_SortArrayByParityII_035 {
    
    static class Solution {
        public int[] sortArrayByParityII(int[] A) {
            if (A == null || A.length == 0) {return A;}
            if (A.length < 2) {return A;}
            int i = 0, j = 1, n = A.length;
            while (i < n && j < n) {
                while (i < n && A[i] % 2 == 0) {
                    i += 2;
                }
                while (j < n && A[j] % 2 == 1) {
                    j += 2;
                }
                if (i < n && j < n) {
                    swap(A, i, j);
                }
            }
            return A;
        }

        private void swap(int[] a, int start, int end) {
            int tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[] { 4, 2, 5, 7 };
        s.sortArrayByParityII(a);
        System.out.println(Arrays.toString(a));

        a = new int[] { 2, 0, 3, 4, 1, 3 };
        s.sortArrayByParityII(a);
        System.out.println(Arrays.toString(a));
        a = new int[] { 4, 1, 2, 1 };
        s.sortArrayByParityII(a);
        System.out.println(Arrays.toString(a));
    }
}
