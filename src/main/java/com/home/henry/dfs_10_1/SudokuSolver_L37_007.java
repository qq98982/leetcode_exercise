package com.home.henry.dfs_10_1;

import java.util.Arrays;

/**
 * 37. Sudoku Solver
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 */
public class SudokuSolver_L37_007 {
    static class Solution {
        public static void solveSudoku(char[][] board) {
            if (board == null || board.length == 0) {return;}
            solve(board);
        }

        private static boolean solve(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    // 如果是'.', 进行遍历, 如果取其中一个值是valid, dfs如果返回true就是确定的,否则还原为'.'
                    if (board[i][j] == '.') {
                        for (char c = '1'; c <= '9'; c++) {
                            if (isValid(board, i, j, c)) {
                                board[i][j] = c;
                                if (solve(board)) {
                                    return true;
                                } else {
                                    board[i][j] = '.';
                                }
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }

        public static boolean isValid(char[][] board, int row, int col, char c) {
            // 如果是在行和列, 还有cubic中都是没有这个c的, 那么就是valid的
            for (int i = 0; i < 9; i++) {
                if (board[i][col] != '.' && board[i][col] == c) {return false;}
                if (board[row][i] != '.' && board[row][i] == c) {return false;}
                // 注意这里的point, 和36中的两个都用%是有区别的
                char point = board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3];
                if (point != '.' && point == c) {return false;}
            }
            return true;
        }
    }

    public static void main(String[] args) {
        char[][] grid =
                {
                        { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                        { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                        { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                        { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                        { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                        { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                        { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                        { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                        { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
                };
        Solution.solveSudoku(grid);
        for (char[] g : grid) {
            System.out.println(Arrays.toString(g));
        }
        char[][] va = {
                { '5', '3', '4', '6', '7', '8', '9', '1', '2' },
                { '6', '7', '2', '1', '9', '5', '3', '4', '8' },
                { '1', '9', '8', '3', '4', '2', '5', '6', '7' },
                { '8', '5', '9', '7', '6', '1', '4', '2', '3' },
                { '4', '2', '6', '8', '5', '3', '7', '9', '1' },
                { '7', '1', '3', '9', '2', '4', '8', '5', '6' },
                { '9', '6', '1', '5', '3', '7', '2', '8', '4' },
                { '2', '8', '7', '4', '1', '9', '6', '3', '5' },
                { '3', '4', '5', '2', '8', '6', '1', '7', '9' }
        };
    }
}
