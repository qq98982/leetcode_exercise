package com.home.henry.binary_search_08;

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 */
public class L378_KthSmallestElementInASortedMatrix_013 {

    public int kthSmallest(int[][] matrix, int k) {
        // corner case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0
            || k > matrix.length * matrix[0].length) {return Integer.MIN_VALUE;}
        int m = matrix.length, n = matrix[0].length;
        int left = matrix[0][0], right = matrix[m - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countNum(matrix, m, n, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // return the count of elements <= mid
    private int countNum(int[][] matrix, int m, int n, int mid) {
        int count = 0;
        int j = n - 1;
        for (int i = 0; i < m; i++) {
            while (j >= 0 && matrix[i][j] > mid) {
                j--;
            }
            count += j + 1;
        }
        return count;
    }
}