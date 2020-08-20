package com.home.henry.union_find_16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 261. Graph Valid Tree
 *
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]] Output: true
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]] Output: false
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * check if these edges form a valid tree.
 * This problem can be converted to finding the cycle from a graph. It can be solved by using
 * DFS (Recursion) or BFS (Queue).
 *
 * 还有就是Union Find
 * 此外还有需要注意的是对于vertex和edge的validation, |E| = |V| - 1 ,也就是
 * 要验证 edges.length == n - 1 ,如果该条件不满足,则Graph一定不是valid tree。
 */
public class L261_GraphValidTree_001 {

    /**
     * DFS
     */
    static class SolutionDFS {
        public boolean validTree(int n, int[][] edges) {
            Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
            for (int i = 0; i < n; i++) {
                List<Integer> list = new ArrayList<Integer>();
                map.put(i, list);
            }

            for (int[] edge : edges) {
                map.get(edge[0]).add(edge[1]);
                map.get(edge[1]).add(edge[0]);
            }

            boolean[] visited = new boolean[n];

            if (!helper(0, -1, map, visited)) { return false; }

            for (boolean b : visited) {
                if (!b) { return false; }
            }

            return true;
        }

        public boolean helper(int curr, int parent, Map<Integer, List<Integer>> map, boolean[] visited) {
            if (visited[curr]) { return false; }
            visited[curr] = true;
            for (int i : map.get(curr)) {
                if (i != parent && !helper(i, curr, map, visited)) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * BFS
     */
    static class SolutionBFS {
        public boolean validTree(int n, int[][] edges) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new ArrayList<>());
            }

            //build the graph
            for (int[] edge : edges) {
                int a = edge[0];
                int b = edge[1];

                list.get(a).add(b);
                list.get(b).add(a);
            }

            //use queue to traverse the graph
            HashSet<Integer> visited = new HashSet<>();
            LinkedList<Integer> q = new LinkedList<>();
            q.offer(0);

            while (!q.isEmpty()) {
                int head = q.poll();

                if (visited.contains(head)) {
                    return false;
                }

                visited.add(head);

                ArrayList<Integer> vList = list.get(head);
                for (int v : vList) {
                    if (!visited.contains(v)) {
                        q.offer(v);
                    }
                }
            }

            if (visited.size() < n) {
                return false;
            }

            return true;
        }
    }

    class UnionFindSet {

        int[] parents;
        int cnt;

        public UnionFindSet(int size) {
            this.parents = new int[size];
            for (int i = 0; i < this.parents.length; i++) {
                this.parents[i] = i;
            }
            this.cnt = size;
        }

        public void union(int m, int n) {
            int src = find(m);
            int dst = find(n);

            this.parents[src] = dst;
            cnt--;
        }

        public int find(int m) {
            while (parents[m] != m) {
                parents[m] = parents[parents[m]];  // for path compression
                m = parents[m];
            }
            return m;
        }

        public int count() {
            return cnt;
        }
    }

    /**
     * UF
     * 此外还有需要注意的是对于vertex和edge的validation, |E| = |V| - 1 ,也就是
     * 要验证 edges.length == n - 1 ,如果该条件不满足,则Graph一定不是valid tree。
     */
    static class ValidTreeUF {

        private static class WeightedUnionFind {
            private int count;
            private int[] size;
            private int[] parent;

            WeightedUnionFind(int n) {
                this.count = n;
                this.size = new int[n];
                this.parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                    count = n;
                }
            }

            public int find(int p) {
                validate(p);
                while (p != parent[p]) {
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

            public void validate(int p) {
                int n = size.length;
                if (p < 0 || p > n) {
                    throw new IllegalArgumentException();
                }
            }
        }

        public boolean validTree(int n, int[][] edges) {
            if (edges.length != n - 1) { return false;}

            WeightedUnionFind uf = new WeightedUnionFind(n);
            for (int i = 0; i < edges.length; i++) {
                int start = edges[i][0];
                int end = edges[i][1];
                // there is cycle, return false
                // [[0,1], [0,2], [0,3], [1,4]] valid tree
                // [[0,1], [1,2], [2,3], [1,3], [1,4]] invalid tree
                if (uf.find(start) == uf.find(end)) {
                    return false;
                } else {
                    uf.union(start, end);
                }
            }
            return uf.count() == 1;
        }
    }
}
