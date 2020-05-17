package com.home.henry.dfs_10_1;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both
 * indicate a queen and an empty space respectively.
 *
 * Example:
 *
 * Input: 4
 * Output: [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class NQueens_L051_008 {

    static class Solution {
        public static List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new ArrayList<>();
            if (n <= 0) {return res;}
            helper(res, new int[n], 0);
            return res;
        }

        // queens里面放的是一个数组, 每一个数字代表的是放在当前index的第几列.
        private static void helper(List<List<String>> res, int[] queens, int pos) {
            if (pos == queens.length) {
                addSolution(res, queens);
                // 注意这里是结束条件, 要return
                return;
            }
            // 看每个位置是不是合适放queen
            for (int i = 0; i < queens.length; i++) {
                queens[pos] = i;
                if (isValid(queens, pos)) {
                    // 如果能放, 走到下一行, pos+1, 继续递归调用
                    helper(res, queens, pos + 1);
                }
            }
        }
        private static boolean isValid(int[] queens, int pos) {
            for (int i = 0; i < pos; i++) {
                // 是不是同一列
                if (queens[i] == queens[pos]) {return false;}
                // 注意这里是i - pos是计算是不是同一斜线
                if (Math.abs(queens[i] - queens[pos]) == Math.abs(pos - i)) {return false;}
            }
            return true;
        }

        private static void addSolution(List<List<String>> res, int[] queens) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < queens.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < queens.length; j++) {
                    if (queens[i] == j) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                list.add(sb.toString());
            }
            res.add(list);
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.solveNQueens(4));
    }
}
