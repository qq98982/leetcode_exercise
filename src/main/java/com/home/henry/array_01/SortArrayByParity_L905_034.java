package com.home.henry.array_01;

/**
 * 905. Sort Array By Parity
 * 排序一个array, 偶数在左, 奇数在右
 */
public class SortArrayByParity_L905_034 {


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
