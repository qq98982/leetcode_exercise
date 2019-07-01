package com.home.henry.array_01;

/**
 * 867. Transpose Matrix
 * 翻转矩阵, 这个是占用空间少的最优解法, 后面的是普通解法
 */
public class TransposeMatrix_L867_041 {
    static class Solution {
        public int[][] transpose(int[][] A) {
            if (A == null || A.length == 0 || A[0] == null || A[0].length == 0) {return A;}
            if (A.length == A[0].length) {
                inPlace(A);
                return A;
            }
            int[][] B = new int[A[0].length][A.length];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    B[j][i] = A[i][j];
                }
            }
            return B;
        }

        private void inPlace(int[][] a) {
            for (int i = 0; i < a.length; i++) {
                for (int j = i; j < a[0].length; j++) {
                    int temp = a[i][j];
                    a[i][j] = a[j][i];
                    a[j][i] = temp;
                }
            }
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
