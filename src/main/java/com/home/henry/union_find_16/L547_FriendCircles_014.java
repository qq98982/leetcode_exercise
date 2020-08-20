package com.home.henry.union_find_16;

/**
 * 547. Friend Circles
 */
public class L547_FriendCircles_014 {
    static class Solution {
        static class UnionFind {
            private int count;
            private int[] size, parent;

            public UnionFind(int n) {
                count = n;
                size = new int[n];
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }

            public int find(int p) {
                while (p != parent[p]) {
                    parent[p] = parent[parent[p]];
                    p = parent[p];
                }
                return p;
            }

            public void union(int p, int q) {
                if (p < 0 || p > parent.length || q < 0 || q > parent.length) {
                    return;
                }
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

            public int count() {
                return count;
            }

            boolean connected(int p, int q) {
                return find(p) == find(q);
            }
        }

        public int findCircleNum(int[][] M) {
            if (M == null || M.length == 0 || M[0] == null || M[0].length == 0) {return 0;}
            int n = M.length;
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (M[i][j] == 1) {
                        uf.union(i, j);
                    }
                }
            }
            return uf.count;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] m1 = new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        int[][] m2 = new int[][] { { 1 }};
        System.out.println(s.findCircleNum(m1));
        System.out.println(s.findCircleNum(m2));
    }
}
