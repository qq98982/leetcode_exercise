package com.home.henry.union_find_16;

import java.util.HashMap;
import java.util.Map;

import com.home.henry.tool.GenRandomArray;

/**
 * 952. Largest Component Size by Common Factor
 * time O(N*sqrt(Max val of A[i])*logN)
 * 求出有common factor的能连接起来的数字的最大的数量
 * 这个问题的要点在于不要time out, 也就是要把common factor计算好
 */
public class LargestComponentSizeByCommonFactor_L952_011 {

    static class Solution {
        static class UnionFind {
            int[] parent, size;
            int count, max;

            UnionFind(int n) {
                parent = new int[n];
                size = new int[n];
                count = n;
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
                max = 1;
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ) {return;}
                int unionMax = 1;
                if (size[rootP] > size[rootQ]) {
                    size[rootP] += size[rootQ];
                    unionMax = size[rootP];
                    parent[rootQ] = rootP;
                } else {
                    size[rootQ] += size[rootP];
                    unionMax = size[rootQ];
                    parent[rootP] = rootQ;
                }
                max = Math.max(unionMax, max);
                count--;
            }

            public int find(int p) {
                valid(p);
                while (p != parent[p]) {
                    parent[p] = parent[parent[p]];
                    p = parent[p];
                }
                return p;
            }

            public void valid(int p) {
                if (p < 0 || p > parent.length - 1) {
                    throw new IllegalArgumentException();
                }
            }

            public boolean connected(int i, int j) {
                return find(i) == find(j);
            }
        }

        public int largestComponentSize(int[] A) {
            if (A == null || A.length == 0) {return 0;}
            int len = A.length;
            UnionFind uf = new UnionFind(len);
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                int a = A[i];
                for (int j = 2; j * j <= a; j++) {
                    if (a % j == 0) {
                        // j是一个factor
                        if (!map.containsKey(j)) {
                            map.put(j, i);
                        } else {
                            uf.union(i, map.get(j));
                        }
                        // a % j == 0 , 所以 a/j也是factor
                        if (!map.containsKey(a / j)) {
                            map.put(a / j, i);
                        } else {
                            uf.union(i, map.get(a / j));
                        }
                    }
                }
                // 如果不能整除, a也是factor, 注意这个的位置
                if (!map.containsKey(a)) {
                    map.put(a, i);
                } else {
                    uf.union(i, map.get(a));
                }
            }
            return uf.max;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.largestComponentSize(new int[] { 4, 6, 15, 35 }));
        // 2
        System.out.println(s.largestComponentSize(new int[] { 20, 50, 9, 63 }));
        // 6
        System.out.println(s.largestComponentSize(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
        int[] ints = GenRandomArray.generateRandomArray(20000, 100000);
        System.out.println(s.largestComponentSize(ints));
    }
}
