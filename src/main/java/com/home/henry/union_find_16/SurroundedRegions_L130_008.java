package com.home.henry.union_find_16;

import com.home.henry.tool.GenRandomArray;

/**
 * 130. Surrounded Regions
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 这个也用Union Find方法做的, 细节比较多. 题意是将没有和四边连起来的O换成X
 */
public class SurroundedRegions_L130_008 {

    static class Solution {
        static class UnionFind {
            int[] parent;
            int[] size;
            int count;

            public UnionFind(char[][] board) {
                int rows = board.length;
                int cols = board[0].length;
                parent = new int[rows * cols + 1];
                size = new int[rows * cols + 1];
                count = rows * cols + 1;
                for (int i = 0; i < parent.length; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }

            }

            private void initUnionFind(char[][] board, int rows, int cols) {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (board[i][j] == 'O') {
                            connectOthers(board, rows, cols, i, j);
                        }
                        if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                            int newId = cols * i + j;
                            if (valid(rows, cols, i, j)) {
                                union(newId, rows * cols);
                            }
                        }
                    }
                }
            }

            private void connectOthers(char[][] board, int rows, int cols, int i, int j) {
                int[][] k = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
                int oldId = i * cols + j;
                for (int x = 0; x < k.length; x++) {
                    int newI = i + k[x][0];
                    int newJ = j + k[x][1];
                    if (valid(rows, cols, newI, newJ)) {
                        int newId = (newI) * cols + newJ;
                        if (board[newI][newJ] == 'O') {
                            union(oldId, newId);
                        }
                    }
                }
            }

            private boolean valid(int rows, int cols, int i, int j) {
                return i >= 0 && i < rows && j >= 0 && j < cols;
            }

            public boolean connected(int p, int q) {
                return find(p) == find(q);
            }

            private void validate(int p) {
                if (p < 0 || p > parent.length) {
                    throw new IllegalArgumentException();
                }
            }

            public int find(int p) {
                validate(p);
                while (p != parent[p]) {
                    parent[p] = parent[parent[p]];
                    p = parent[p];
                }
                return p;
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ) {return;}
                if (size[rootP] > size[rootQ]) {
                    parent[rootQ] = rootP;
                    size[rootP] += size[rootQ];
                } else {
                    parent[rootP] = rootQ;
                    size[rootQ] += size[rootP];
                }
                count--;
            }
        }

        public void solve(char[][] board) {
            if (board == null || board.length == 0) { return;}
            if (board[0] == null || board[0].length == 0) { return;}
            UnionFind uf = new UnionFind(board);
            int cols = board[0].length;
            int rows = board.length;
            uf.initUnionFind(board, rows, cols);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int id = i * cols + j;
                    if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                        continue;
                    }
                    if (board[i][j] == 'O' && !uf.connected(id, rows * cols)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] grid = {
                { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X' }
        };
        char[][] grid2 = {
                { 'X', 'X', 'O', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X' }
        };
        printGrid(s, grid);
        System.out.println();
        printGrid(s, grid2);
        char[][] grid3 = { {} };
        printGrid(s, grid3);
        System.out.println();
        char[][] grid4 = { { 'O' } };
        printGrid(s, grid4);
        System.out.println();
        char[][] grid5 = {
                { 'X', 'O', 'X', 'X' }, { 'O', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'O' }
                , { 'O', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'O' },
                { 'O', 'X', 'O', 'X' }
        };
        printGrid(s, grid5);
    }

    private static void printGrid(Solution s, char[][] grid) {
        s.solve(grid);
        for (int i = 0; i < grid.length; i++) {
            GenRandomArray.printArray(grid[i]);
        }
    }
}
