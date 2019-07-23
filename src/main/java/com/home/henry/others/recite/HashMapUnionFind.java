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
        /**
         * 进行路径压缩, 如果没有也不影响当前的返回结果, 会优化后续的搜索
         */
        int fa = parMap.get(p);
        while (fa != parMap.get(fa)) {
            int temp = parMap.get(fa);
            parMap.put(fa, parent);
            fa = temp;
        }
        return parent;
    }

    /**
     * 老大哥之间合并 跟小弟没关系
     */
    void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            parMap.put(rootP, rootQ);
        }
    }
}
