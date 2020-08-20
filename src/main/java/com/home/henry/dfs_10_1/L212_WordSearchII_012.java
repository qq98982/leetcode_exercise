package com.home.henry.dfs_10_1;

import java.util.ArrayList;
import java.util.List;

/**
 * 212. Word Search II
 *
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 *
 * Input:
 * board = [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 *
 * Output: ["eat","oath"]
 *
 * Note:
 *
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 *
 * 分离了dfs和判断的逻辑
 */
public class L212_WordSearchII_012 {
    static class Solution {
        public static List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList<>();
            for (String word : words) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[0].length; j++) {
                        if (board[i][j] == word.charAt(0) && exist(board, visited, word, i, j, 0)) {
                            if (!res.contains(word)) {
                                res.add(word);
                            }
                        }
                    }
                }

            }
            return res;
        }

        private static boolean exist(char[][] board, boolean[][] visited, String word, int row, int col,
                                     int n) {
            if (n == word.length()) {return true;}
            if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]
                || board[row][col] != word.charAt(n)) {return false;}
            board[row][col] = '*';
            boolean res = exist(board, visited, word, row + 1, col, n + 1) ||
                          exist(board, visited, word, row - 1, col, n + 1) ||
                          exist(board, visited, word, row, col + 1, n + 1) ||
                          exist(board, visited, word, row, col - 1, n + 1);
            board[row][col] = word.charAt(n);
            return res;
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' }
        };
        System.out.println("[eat, oath]" + " " + Solution
                .findWords(board, new String[] { "oath", "pea", "eat", "rain" }));
        char[][] board2 = {{'a', 'a'}};
        System.out.println("[aa]" + " " + Solution.findWords(board2,new String[]{"aa"}));
    }
}
