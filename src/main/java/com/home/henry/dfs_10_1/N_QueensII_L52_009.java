package com.home.henry.dfs_10_1;

/**
 * 52. N-Queens II
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 * Input: 4 Output: 2
 */
public class N_QueensII_L52_009 {
    static class Solution {
        private int res = 0;
        public int totalNQueens(int n) {
            if (n <= 0) {return res;}
            helper(new int[n], 0);
            return res;
        }

        // queens里面放的是一个数组, 每一个数字代表的是放在当前index的第几列.
        private void helper(int[] queens, int pos) {
            if (pos == queens.length) {
                res++;
                // 注意这里是结束条件, 要return
                return;
            }
            // 看每个位置是不是合适放queen
            for (int i = 0; i < queens.length; i++) {
                queens[pos] = i;
                if (isValid(queens, pos)) {
                    // 如果能放, 走到下一行, pos+1, 继续递归调用
                    helper(queens, pos + 1);
                }
            }
        }
        private boolean isValid(int[] queens, int pos) {
            for (int i = 0; i < pos; i++) {
                // 是不是同一列
                if (queens[i] == queens[pos]) {return false;}
                // 注意这里是i - pos是计算是不是同一斜线
                if (Math.abs(queens[i] - queens[pos]) == Math.abs(pos - i)) {return false;}
            }
            return true;
        }
    }
}
