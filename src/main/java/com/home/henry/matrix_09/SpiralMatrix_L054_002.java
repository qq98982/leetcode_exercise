package com.home.henry.matrix_09;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 后一种方法更不容易出错
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

    static class Solution2 {
        public static List<Integer> spiralOrder(int[][] matrix) {
            // 顺时针走四个边
            List<Integer> res = new ArrayList<>();
            int tR = 0, tC = 0, dR = matrix.length - 1, dC = matrix[0].length - 1;
            while (tR <= dR && tC <= dC) {
                printEdge(res, matrix, tR++, dR--, tC++, dC--);
            }
            return res;
        }

        private static void printEdge(List<Integer> res, int[][] matrix, int tR, int dR, int tC, int dC) {
            // 只有一行
            if (tR == dR) {
                // 注意这里i不是从0开始
                for (int i = tC; i <= dC; i++) {
                    res.add(matrix[tR][i]);
                }
            } else if (tC == dC) {
                // 只有一列
                // 注意这里i不是从0开始
                for (int i = tR; i <= dR; i++) {
                    res.add(matrix[i][tC]);
                }
            } else {
                // 一般情况
                int currC = tC;
                int currR = tR;
                // 左上->右上
                while (currC != dC) {
                    res.add(matrix[tR][currC]);
                    currC++;
                }
                // 右上->右下
                while (currR != dR) {
                    res.add(matrix[currR][dC]);
                    currR++;
                }
                // 右下->左下
                while (currC != tC) {
                    res.add(matrix[dR][currC]);
                    currC--;
                }
                // 左下->左上
                while (currR != tR) {
                    res.add(matrix[currR][tC]);
                    currR--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        int count = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = count++;
            }
        }
        for (int[] r : matrix) {
            for (int n : r) {
                System.out.print(n + " ");
            }
        }
        System.out.println(Solution2.spiralOrder(matrix));
    }
}
