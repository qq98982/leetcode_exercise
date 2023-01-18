package com.home.henry.array_01;

/**
 * 977. Squares of a Sorted Array
 *
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of
 * each number sorted in non-decreasing order.
 *
 * Input: [-4,-1,0,3,10] Output: [0,1,9,16,100]
 * Input: [-7,-3,2,3,11] Output: [4,9,9,49,121]
 */
public class L977_SquaresOfASortedArray_036 {

    public int[] sortedSquares(int[] A) {
        if (A == null) {return new int[]{};}
        int[] res = new int[A.length];
        int i = 0, j = A.length - 1;
        for (int k = A.length - 1; k >= 0; k--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                res[k] = A[i] * A[i++];
            } else {
                res[k] = A[j] * A[j--];
            }
        }
        return res;
    }
}
