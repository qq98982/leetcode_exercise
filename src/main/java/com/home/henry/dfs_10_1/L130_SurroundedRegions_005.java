package com.home.henry.dfs_10_1;

/**
 * 130. Surrounded Regions
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */
public class L130_SurroundedRegions_005 {

    public void solve(char[][] board) {
        if (board.length == 0) {return;}
        if (board[0].length == 0) {return;}
        int m = board.length;
        int n = board[0].length;
        // dfs from 1st and last cols
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        // dfs from 1st and last rows
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '#') {
                    board[i][j] = 'X';
                } else {
                    board[i][j] = 'O';
                }
            }
        }
    }

    // mark all Os connected with border with #
    private void dfs(char[][] board, int i, int j) {
        // row
        int m = board.length;
        // col
        int n = board[0].length;
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || board[i][j] != 'O') {return;}
        board[i][j] = '#';
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };
        // 这个是省略的写法, 和以前的(i, j+1) (i, j-1) (i+1, j) (i-1,j)没有区别
        for (int k = 0; k < dx.length; k++) {
            dfs(board, i + dx[k], j + dy[k]);
        }
    }

}
