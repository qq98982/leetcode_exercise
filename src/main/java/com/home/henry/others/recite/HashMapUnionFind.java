package com.home.henry.others.recite;

import java.util.HashMap;
import java.util.Map;

public class HashMapUnionFind {

    private Map<Integer, Integer> parent = new HashMap<>();
    private Map<Integer, Integer> size = new HashMap<>();

    public HashMapUnionFind(int n) {
        for (int i = 0; i < n; i++) {
            parent.put(i, i);
            size.put(i, 1);
        }
    }

    public int find(int p) {
        int o = parent.get(p);
        if (o != p) {
            o = find(o);
        }
        parent.put(p, o);
        return o;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            int pSize = size.get(rootP);
            int qSize = size.get(rootQ);
            if (pSize >= qSize) {
                parent.put(rootQ, rootP);
                size.put(pSize, pSize + qSize);
            } else {
                parent.put(rootP, rootQ);
                size.put(qSize, pSize + qSize);
            }
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

}
