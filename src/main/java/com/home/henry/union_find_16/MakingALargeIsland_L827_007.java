package com.home.henry.union_find_16;

import java.util.HashSet;
import java.util.Set;

/**
 * 827. Making A Large Island
 * 用UF 9ms, DFS 94ms
 * 思路: 先生成一个array based union find, 然后遍历所有不为1的点, 加上这个点旁边的为1的点的最高级的size值
 * 用一个set放这个最高级, 防止重复添加, 然后得出这个点能连接的最大值, 并和其他为0的点的最大值进行比较
 * 最后最大的就是结果
 */
public class MakingALargeIsland_L827_007 {
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
            return newI >= 0 && newI < rows && newJ >= 0 && newJ < cols;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // 3
        int[][] grid = { { 1, 0 }, { 0, 1 } };
        System.out.println(s.largestIsland(grid));

        // 4
        int[][] gridSec = { { 1, 1 }, { 1, 0 } };
        System.out.println(s.largestIsland(gridSec));

        // 4
        int[][] gridThr = { { 1, 1 }, { 1, 1 } };
        System.out.println(s.largestIsland(gridThr));
        // 1
        int[][] gridFur = { { 0, 0 }, { 0, 0 } };
        System.out.println(s.largestIsland(gridFur));

        // 2
        int[][] gridFiv = { { 0, 0 }, { 0, 1 } };
        System.out.println(s.largestIsland(gridFiv));
    }
}
