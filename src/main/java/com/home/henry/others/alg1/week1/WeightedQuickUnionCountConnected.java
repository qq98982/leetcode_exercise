package com.home.henry.others.alg1.week1;

/**
 * Social network connectivity
 *
 * Given a social network containing n members and a log file containing m timestamps at which times pairs of members
 * formed friendships, design an algorithm to determine the earliest time at which all members are connected
 * (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted by
 * timestamp and that friendship is an equivalence relation. The running time of your algorithm should be mlogn or
 * better and use extra space proportional to n.
 */
public class WeightedQuickUnionCountConnected {
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnionCountConnected(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        this.id = new int[n];
        this.sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
        count = n;
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public boolean allUnioned() {
        return count == 1;
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (pRoot == qRoot) {return;}
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        count--;
    }

}