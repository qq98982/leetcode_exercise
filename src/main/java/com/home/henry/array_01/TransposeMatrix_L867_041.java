package com.home.henry.array_01;

/**
 * 867. Transpose Matrix
 *
 * Given a matrix A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
 *
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 *
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 * 翻转矩阵, 第一个是占用空间少的最优解法, 先考虑是不是row和col相等, 如果相等不需要额外空间
 * 后面的是普通解法, 创建一个额外matrix进行交换
 */
public class TransposeMatrix_L867_041 {
    static class Solution {
        public int[][] transpose(int[][] A) {
            if (A == null || A.length == 0 || A[0] == null || A[0].length == 0) {return A;}
            int row = A.length, col = A[0].length;
            if (row == col) {
                for (int i = 0; i < row; i++) {
                    for (int j = i; j < col; j++) {
                        int tmp = A[i][j];
                        A[i][j] = A[j][i];
                        A[j][i] = tmp;
                    }
                }
                return A;
            }
            int[][] B = new int[col][row];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    B[j][i] = A[i][j];
                }
            }
            return B;
        }
    }

    static class SolutionReverse {
        public int[][] tranpose(int[][] A) {
            int M = A.length, N = A[0].length;
            int[][] B = new int[N][M];
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < M; i++) {
                    B[j][i] = A[i][j];
                }
            }
            return B;
        }
    }
}
