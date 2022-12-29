package com.home.henry.others.recite;

public class WeightedUnionFind {
    int count;
    int[] size, parent;

    WeightedUnionFind(int n) {
        this.count = n;
        this.size = new int[n];
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public void validate(int p) {
        int n = parent.length;
        if (p < 0 || p > n) {
            throw new IllegalArgumentException();
        }
    }

    public int find(int p) {
        validate(p);
        while (p != parent[p]) {
            // path compression
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {return;}
        if (size[rootP] > size[rootQ]) {
            // smaller tree added to the bigger one
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }
}
