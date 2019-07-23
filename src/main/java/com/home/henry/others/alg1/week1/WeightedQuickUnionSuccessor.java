package com.home.henry.others.alg1.week1;

public class WeightedQuickUnionSuccessor {

    private int[] id, mArray, sz;

    private int count;

    WeightedQuickUnionSuccessor(int n) {
        this.id = new int[n];
        this.sz = new int[n];
        this.mArray = new int[n];
        this.count = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
            mArray[i] = i;
            sz[i] = 1;
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
        if (sz[pRoot] > sz[qRoot]) {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        } else {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        mArray[pRoot] = max;
        mArray[qRoot] = max;
        count--;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
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
