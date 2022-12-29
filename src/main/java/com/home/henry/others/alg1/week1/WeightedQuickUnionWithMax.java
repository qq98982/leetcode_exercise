package com.home.henry.others.alg1.week1;

/**
 * Union-find with specific canonical element.
 *
 * Add a method find() to the union-find data type so that find(i) returns the largest element in the connected
 * component containing i. The operations, union(), connected(), and find() should all take logarithmic time or better.
 */
public class WeightedQuickUnionWithMax {
    private int[] parent;
    private int[] size;
    private int[] max;
    private int count;

    public WeightedQuickUnionWithMax(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        this.parent = new int[n];
        this.size = new int[n];
        this.count = n;
        this.max = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            max[i] = i;
        }
    }

    private int root(int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
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
        int max = Math.max(this.max[pRoot], this.max[qRoot]);
        if (size[pRoot] < size[qRoot]) {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
        this.max[pRoot] = max;
        this.max[qRoot] = max;
        count--;
    }

    private int find(int i) {
        return this.max[root(i)];
    }

    public static void main(String[] args) {
        WeightedQuickUnionWithMax w = new WeightedQuickUnionWithMax(10);
        w.union(1, 2);
        w.union(3, 4);
        w.union(5, 6);
        w.union(6, 7);
        w.union(8, 9);
        w.union(1, 9);
        System.out.println(w.connected(2, 9)); // true
        System.out.println(w.connected(3, 9)); // false
        System.out.println(w.connected(3, 7)); // false
        System.out.println(w.connected(3, 0)); // false
        System.out.println(w.connected(0, 0)); // true
        System.out.println(w.connected(7, 5)); // true
        System.out.println(w.find(1));
        System.out.println(w.find(3));
        System.out.println(w.find(4));
        System.out.println(w.allUnioned());
        w.union(0, 9);
        w.union(3, 7);
        w.union(3, 9);
        System.out.println(w.allUnioned());
        System.out.println(w.find(4));

    }

}
