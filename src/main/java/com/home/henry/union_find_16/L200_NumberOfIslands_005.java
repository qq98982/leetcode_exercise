package com.home.henry.union_find_16;

import java.util.HashMap;
import java.util.Map;

/**
 * 200. Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 *
 * 这个题用DFS更简便, 不容易出错
 * 使用map uf是29ms, array uf是5ms(不根据size进行优化也是5ms)
 */
public class L200_NumberOfIslands_005 {

    static class SolutionArrayUF {
        static class IslandUnionFind {
            int[] root;
            int count = 0;
            int[] size;

            IslandUnionFind(char[][] grid) {
                int m = grid.length;
                int n = grid[0].length;

                root = new int[m * n];
                size = new int[m * n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] == '1') {
                            int id = i * n + j;
                            root[id] = id;
                            size[id] = 1;
                            count++;
                        }
                    }
                }
            }

            public int find(int p) {
                validate(p);
                int parent = p;
                while (parent != root[parent]) {
                    root[parent] = root[root[parent]];
                    parent = root[parent];
                }
                return parent;
            }

            private void validate(int p) {
                if (p < 0 || p > root.length) {
                    throw new IllegalArgumentException();
                }
            }

            public int count() {
                return count;
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP != rootQ) {
                    if (size[rootP] > size[rootQ]) {
                        root[rootQ] = rootP;
                        size[rootP] += size[rootQ];
                    } else {
                        root[rootP] = rootQ;
                        size[rootQ] += size[rootP];
                    }
                    count--;
                }
            }
        }

        public int numIslands(char[][] grid) {
            int[][] distance = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
            if (grid == null || grid.length == 0) { return 0;}
            if (grid[0] == null || grid[0].length == 0) { return 0;}
            IslandUnionFind uf = new IslandUnionFind(grid);
            int rows = grid.length, cols = grid[0].length;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '1') {
                        for (int[] d : distance) {
                            int x = i + d[0];
                            int y = j + d[1];
                            if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {
                                int id1 = i * cols + j;
                                int id2 = x * cols + y;
                                uf.union(id1, id2);
                            }
                        }
                    }
                }
            }
            return uf.count();
        }
    }

    public static void main(String[] args) {
        SolutionArrayUF s = new SolutionArrayUF();
        char[][] input = {
                { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        char[][] input2 = {
                { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        // 1
        System.out.println(s.numIslands(input));
        // 3
        System.out.println(s.numIslands(input2));
    }

    static class SolutionMapUF {
        static class IslandUnionFind {
            Map<Integer, Integer> map = new HashMap<>();
            int count = 0;

            IslandUnionFind(char[][] grid) {
                int m = grid.length;
                int n = grid[0].length;
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] == '1') {
                            int id = i * n + j;
                            map.put(id, map.getOrDefault(id, id));
                            count++;
                        }
                    }
                }
            }

            public int find(int p) {
                int parent = p;
                while (parent != map.getOrDefault(parent, parent)) {
                    parent = map.getOrDefault(parent, parent);
                }
                int fa = map.getOrDefault(p, p);
                while (fa != map.getOrDefault(fa, fa)) {
                    int temp = map.getOrDefault(fa, fa);
                    map.put(fa, parent);
                    fa = temp;
                }
                return parent;
            }

            public int count() {
                return count;
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP != rootQ) {
                    if (map.get(rootP) != null) {
                        count--;
                    }
                    map.put(rootP, rootQ);
                }

            }
        }

        public int numIslands(char[][] grid) {
            int[][] distance = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
            if (grid == null || grid.length == 0) { return 0;}
            if (grid[0] == null || grid[0].length == 0) { return 0;}
            IslandUnionFind uf = new IslandUnionFind(grid);
            int rows = grid.length, cols = grid[0].length;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '1') {
                        for (int[] d : distance) {
                            int x = i + d[0];
                            int y = j + d[1];
                            if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {
                                int id1 = i * cols + j;
                                int id2 = x * cols + y;
                                uf.union(id1, id2);
                            }
                        }
                    }
                }
            }
            return uf.count();
        }
    }

}
