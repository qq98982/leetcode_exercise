package com.home.henry.binary_search_08;

/**
 * 74. Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * 要点在于当做一个array, 用二分搜索
 */
public class SearchA2DMatrix_L074_012 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {return false;}
        int m = matrix.length, n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {return false;}
        int left = 0, right = (matrix[0].length * matrix.length) - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int[] rowCol = getRowCol(mid, matrix[0].length);
            int midElement = matrix[rowCol[0]][rowCol[1]];
            if (midElement == target) {
                return true;
            }
            if (midElement > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    private int[] getRowCol(int mid, int length) {
        return new int[] {mid / length, mid % length};
    }

}
