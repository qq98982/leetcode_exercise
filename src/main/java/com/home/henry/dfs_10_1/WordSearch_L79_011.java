package com.home.henry.dfs_10_1;

/**
 * 79. Word Search
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 *
 * Constraints:
 *
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class WordSearch_L79_011 {

    class Solution {
        public boolean exist(char[][] board, String word) {
            if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
                return false;
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, String word, int row, int col, int n) {
            if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {return false;}

            if (word.charAt(n) != board[row][col]) {
                return false;
            }
            if (n == word.length() - 1) {
                return true;
            }
            // 这里很重要, 更改完后, 后面需要再更改回来
            board[row][col] = '*';
            boolean res = dfs(board, word, row + 1, col, n + 1) ||
                          dfs(board, word, row - 1, col, n + 1) ||
                          dfs(board, word, row, col + 1, n + 1) ||
                          dfs(board, word, row, col - 1, n + 1);
            board[row][col] = word.charAt(n);
            return res;
        }
    }

}
