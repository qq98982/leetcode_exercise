package com.home.henry.union_find_16;

/**
 * 1971. Find if Path Exists in Graph
 */
public class L1971_FindIfPathExistsInGraph_015 {
    private static class UnionFind {
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
            if (p < 0 || p > parent.length) {throw new IllegalArgumentException();}
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind d = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            d.union(edges[i][0], edges[i][1]);
        }
        return d.connected(source, destination);
    }
}
