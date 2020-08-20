package com.home.henry.array_01;

/**
 * 905. Sort Array By Parity
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed
 * by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 * Input: [3,1,2,4] Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * 排序一个array, 偶数在左, 奇数在右
 */
public class L905_SortArrayByParity_034 {


    class Solution {
        public int[] sortArrayByParity(int[] A) {
            if (A == null || A.length <= 1) {return A;}
            int slow = 0;
            int fast = A.length - 1;
            while (fast > slow) {
                if (A[fast] % 2 < A[slow] % 2) {
                    swap(A, fast, slow);
                }
                if (A[slow] % 2 == 0) {slow++;}
                if (A[fast] % 2 == 1) {fast--;}
            }
            return A;
        }

        private void swap(int[] arr, int start, int end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }
    }

}
