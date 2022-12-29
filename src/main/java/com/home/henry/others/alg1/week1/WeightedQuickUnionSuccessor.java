package com.home.henry.others.alg1.week1;

/**
 * Successor with delete.
 * Given a set of n integers  S = { 0, 1, ... , n-1 }
 * S={0,1,...,n−1} and a sequence of requests of the following form:
 * Remove x from S
 * Find the successor of x: the smallest y in S such that y >= x.
 * design a data type so that all operations (except construction)  take logarithmic time or better in the worst case.
 */
public class WeightedQuickUnionSuccessor {

    private int[] parent, mArray, size;

    private int count;

    WeightedQuickUnionSuccessor(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        this.mArray = new int[n];
        this.count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            mArray[i] = i;
            size[i] = 1;
        }
    }

    public boolean allUnioned() {
        return count == 1;
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (pRoot == qRoot) {return;}
        int max = Math.max(mArray[pRoot], mArray[qRoot]);
        if (size[pRoot] > size[qRoot]) {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        } else {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
        mArray[pRoot] = max;
        mArray[qRoot] = max;
        count--;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    public int find(int p) {
        return mArray[root(p)];
    }

    public int remove(int p) {
        union(p, p + 1);
        return find(p);
    }

    public int succssor(int p) {
        return find(p);
    }

    public static void main(String[] args) {
        WeightedQuickUnionSuccessor w2 = new WeightedQuickUnionSuccessor(10);
        System.out.println(w2.remove(2));
        System.out.println(w2.remove(7));
        System.out.println(w2.remove(3));
    }
}
