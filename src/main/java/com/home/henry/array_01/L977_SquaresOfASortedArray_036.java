package com.home.henry.array_01;

/**
 * 977. Squares of a Sorted Array
 * Input: [-4,-1,0,3,10] Output: [0,1,9,16,100]
 * Input: [-7,-3,2,3,11] Output: [4,9,9,49,121]
 */
public class L977_SquaresOfASortedArray_036 {

    static class Solution {
        public int[] sortedSquares(int[] A) {
            int n = A.length;
            int [] res = new int[n];
            int i = 0, j = n - 1;
            for (int p = n - 1; p >= 0; p--) {
                if (Math.abs(A[i]) > Math.abs(A[j])) {
                    res[p] = A[i] * A[i++];
                } else {
                    res[p] = A[j] * A[j--];
                }
            }
            return res;
        }
    }
}
