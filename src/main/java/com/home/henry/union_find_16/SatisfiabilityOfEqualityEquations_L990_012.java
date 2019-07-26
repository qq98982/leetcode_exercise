package com.home.henry.union_find_16;

/**
 * 990. Satisfiability of Equality Equations
 * Input: ["a==b","b==c","a==c"] Output: true
 * Input: ["a==b","b!=c","c==a"] Output: false
 * Input: ["c==c","b==d","x!=z"] Output: true
 */
public class SatisfiabilityOfEqualityEquations_L990_012 {

    static class Solution {

        static class UnionFind {
            private int[] parent, size;
            private int count;

            UnionFind(int n) {
                parent = new int[n];
                size = new int[n];
                count = n;
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }

            public int find(int p) {
                valid(p);
                while (p != parent[p]) {
                    parent[p] = parent[parent[p]];
                    p = parent[p];
                }
                return p;
            }

            public void union(int p, int q) {
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

            public int count() {
                return count;
            }

            public boolean connected(int p, int q) {
                return find(p) == find(q);
            }

            private void valid(int p) {
                if (p < 0 || p >= parent.length) { throw new IllegalArgumentException();}
            }
        }

        public boolean equationsPossible(String[] equations) {
            if (equations == null || equations.length == 0) {
                return true;
            }
            UnionFind uf = new UnionFind(26);
            for (String eq : equations) {
                if (eq.charAt(1) == '=') {
                    uf.union(eq.charAt(0) - 'a', eq.charAt(3) - 'a');
                }
            }
            for (String eq : equations) {
                if (eq.charAt(1) == '!') {
                    if (uf.connected(eq.charAt(0) - 'a', eq.charAt(3) - 'a')) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.equationsPossible(new String[] { "a==b", "b==c", "a==c" }));
        // false
        System.out.println(s.equationsPossible(new String[] { "a==b", "b!=a" }));
        // false
        System.out.println(s.equationsPossible(new String[] { "a==b", "b!=c", "c==a" }));
        // true
        System.out.println(s.equationsPossible(new String[] {"c==c","b==d","x!=z"}));
    }
}
