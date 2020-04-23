package com.home.henry.bfs_10_2;

import java.util.HashSet;
import java.util.Set;

/**
 * 827. Making A Large Island
 * In a 2D grid of 0s and 1s, we change at most one 0 to a 1.
 * After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).
 * Input: [[1, 0], [0, 1]] Output: 3
 * Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 * Input: [[1, 1], [1, 0]] Output: 4
 * Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
 * Input: [[1, 1], [1, 1]] Output: 4
 * Explanation: Can't change any 0 to 1, only one island with area = 4.
 */
public class MakingALargeIsland_L827_005 {
    public int largestIsland(int[][] grid) {
        int max = -1, n = grid.length;
        if (n == 0) {return 0;}
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    max = Math.max(max, dfs(grid, i, j, new boolean[n][m]));
                    // You turn the grid from 0 to 1 and try to get a bigger island. Then you turn it back and try another 0 grid.
                    // If you don't turn it back, finally all the grid will be 1 and there would be only one island.
                    grid[i][j] = 0;
                }
            }
        }
        return max == -1 ? m * n : max;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] seen) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1 || seen[i][j]) {
            return 0;
        }
        seen[i][j] = true;
        return 1 + dfs(grid, i + 1, j, seen) + dfs(grid, i - 1, j, seen) + dfs(grid, i, j + 1, seen) + dfs(
                grid, i, j - 1, seen);
    }
    // Union Find
    static class Solution {
        static class UnionFind {
            int[] parent;
            int[] size;
            int count;

            UnionFind(int n) {
                this.parent = new int[n];
                size = new int[n];
                this.count = n;
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }

            void union(int p, int q) {
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

            private int find(int p) {
                validate(p);
                while (p != parent[p]) {
                    parent[p] = parent[parent[p]];
                    p = parent[p];
                }
                return p;
            }

            private void validate(int p) {
                if (p < 0 || p > parent.length) { throw new IllegalArgumentException();}
            }
        }

        public int largestIsland(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;

            // create father array and size array, and initialize them
            int[] father = new int[rows * cols];
            for (int i = 0; i < father.length; i++) {
                father[i] = i;
            }
            UnionFind uf = new UnionFind(rows * cols);
            int[] dx = { 0, 1, -1, 0 };
            int[] dy = { 1, 0, 0, -1 };
            // scan grid, update father array and size array
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 1) {
                        int id = i * cols + j;
                        for (int k = 0; k < 4; k++) {
                            int newI = i + dx[k];
                            int newJ = j + dy[k];
                            int newId = newI * cols + newJ;
                            if (validateIndex(newI, newJ, cols, rows) && grid[newI][newJ] == 1) {
                                uf.union(id, newId);
                            }
                        }
                    }
                }
            }
            // find current max component size
            int max = 0;
            for (int i = 0; i < rows * cols; i++) {
                max = Math.max(max, uf.size[i]);
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 0) {
                        int combindeSize = 1;
                        Set<Integer> preFather = new HashSet<>();
                        for (int k = 0; k < 4; k++) {
                            int newI = i + dx[k];
                            int newJ = j + dy[k];
                            int newId = newI * cols + newJ;
                            if (validateIndex(newI, newJ, cols, rows) && grid[newI][newJ] == 1) {
                                int currFather = uf.find(newId);
                                if (preFather.isEmpty() || !preFather.contains(currFather)) {
                                    combindeSize += uf.size[currFather];
                                    preFather.add(currFather);
                                }
                            }
                        }
                        max = Math.max(max, combindeSize);
                    }
                }
            }

            return max == 0 ? rows * cols : max;
        }

        private boolean validateIndex(int newI, int newJ, int cols, int rows) {
            if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols) {
                return true;
            }
            return false;
        }
    }
}
