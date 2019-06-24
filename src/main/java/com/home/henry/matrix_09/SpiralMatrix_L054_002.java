package com.home.henry.matrix_09;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 */
public class SpiralMatrix_L054_002 {

    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();

            if (matrix == null || matrix.length == 0) {return res;}
            if (matrix[0] == null || matrix[0].length == 0) {return res;}

            int rowBegin = 0, rowEnd = matrix.length - 1, colBegin = 0, colEnd = matrix[0].length - 1;

            while (rowBegin <= rowEnd && colBegin <= colEnd) {

                // Traverse Right
                for (int i = 0; i <= rowEnd; i++) {
                    res.add(matrix[rowBegin][i]);
                }

                // Traverse Down
                rowBegin++;
                for (int i = rowBegin; i <= rowEnd; i++) {
                    res.add(matrix[i][colEnd]);
                }
                colEnd--;

                // Take a 1X3 matrix, and go through the code, you'll find that if you don't add
                // rowBegin<=rowEnd you'll keep adding duplicated elements into your list, since
                // when the range of rows expired, the loop for col can still go on.
                if (rowBegin <= rowEnd) {
                    // Traverse Left
                    for (int i = colEnd; i >= colBegin; i--) {
                        res.add(matrix[rowEnd][i]);
                    }
                }
                rowEnd--;

                if (colBegin <= colEnd) {
                    // Traver Up
                    for (int i = rowEnd; i >= rowBegin; i--) {
                        res.add(matrix[i][colBegin]);
                    }
                }
                colBegin++;
            }
            return res;
        }
    }
}
