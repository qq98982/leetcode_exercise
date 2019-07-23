package com.home.henry.others.recite;

import java.util.HashMap;
import java.util.Map;

public class HashMapUnionFind {
    Map<Integer, Integer> parMap = new HashMap<>();

    int find(int p) {
        int parent = p;
        while (parent != parMap.get(parent)) {
            parent = parMap.get(parent);
        }
        return parent;
    }

    void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            parMap.put(rootP, rootQ);
        }
    }
}
