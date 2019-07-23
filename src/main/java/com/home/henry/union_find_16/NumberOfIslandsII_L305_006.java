package com.home.henry.union_find_16;

import java.util.ArrayList;
import java.util.List;

/**
 * 305. Number of Islands II
 *
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation
 * which turns the water at position (row, col) into a land. Given a list of positions to operate,count the
 * number of islands after each addLand operation. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]] Output: [1,1,2,3]
 */
public class NumberOfIslandsII_L305_006 {
    static class Solution {
        static class UnionFind {
            int[] parent;
            int[] size;
            int count;

            UnionFind(int x) {
                parent = new int[x];
                count = 0;
                size = new int[x];
                for (int i = 0; i < x; i++) {
                    parent[i] = -1;
                    size[i] = 0;
                }
            }

            public int count() {
                return count;
            }

            public boolean isValid(int p) {
                validate(p);
                return parent[p] >= 0;
            }

            public int find(int p) {
                validate(p);
                while (p != parent[p]) {
                    parent[p] = parent[parent[p]];
                    p = parent[p];
                }
                return p;
            }

            public void validate(int p) {
                if (p < 0 || p > parent.length) {
                    throw new IllegalArgumentException();
                }
            }

            public void setParent(int p) {
                parent[p] = p;
                count++;
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ) {return;}
                if (size[rootP] > size[rootQ]) {
                    size[rootP] += size[rootQ];
                    parent[rootQ] = rootP;
                } else {
                    size[rootQ] += size[rootP];
                    parent[rootP] = rootQ;
                }
                count--;
            }

        }

        public List<Integer> numIslands(int m, int n, int[][] positions) {
            List<Integer> res = new ArrayList<>();
            UnionFind uf = new UnionFind(m * n);
            int[][] distance = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
            for (int[] pos : positions) {
                int r = pos[0], c = pos[1];
                int id = r * n + c;
                uf.setParent(id);
                for (int[] dis : distance) {
                    int nr = r + dis[0];
                    int nc = c + dis[1];
                    int nid = nr * r + nc;
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        if (uf.isValid(nid)) {
                            uf.union(nid, id);
                        }
                    }
                }
                res.add(uf.count);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] points = { { 0, 0 }, { 0, 1 }, { 1, 2 }, { 2, 1 } };
        System.out.println(s.numIslands(3, 3, points));
    }
}
