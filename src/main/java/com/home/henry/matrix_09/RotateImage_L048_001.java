package com.home.henry.matrix_09;

/**
 * 48. Rotate Image
 */
public class RotateImage_L048_001 {

    static class Solution {
        public void rotate(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                // important j = i
                for (int j = i; j < matrix[0].length; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length / 2; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix.length - 1 - j];
                    matrix[i][matrix.length - 1 - j] = tmp;
                }
            }
        }
    }
}
