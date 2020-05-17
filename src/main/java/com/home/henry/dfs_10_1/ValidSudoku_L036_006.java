package com.home.henry.dfs_10_1;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. Valid Sudoku
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * A partially filled sudoku which is valid.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Example 1:
 *
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * Example 2:
 *
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 */
public class ValidSudoku_L036_006 {

    class Solution {
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                Set<Character> cols = new HashSet<>(9);
                Set<Character> rows = new HashSet<>(9);
                Set<Character> cube = new HashSet<>(9);
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] != '.' && !rows.add(board[i][j])) {
                        return false;
                    }
                    if (board[j][i] != '.' && !cols.add(board[j][i])) {
                        return false;
                    }
                    int rowIndex = 3 * (i / 3);
                    int colIndex = 3 * (i % 3);
                    char point = board[rowIndex + j / 3][colIndex + j % 3];
                    if (point != '.' && !cube.add(point)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
