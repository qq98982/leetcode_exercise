package com.home.henry.union_find_16;

/**
 * 323. Number of Connected Components in an Undirected Graph
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write
 * a function to find the number of connected components in an undirected graph.
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 * https://www.programcreek.com/2014/05/leetcode-number-of-connected-components-in-an-undirected-graph-java/
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph_L323_002 {
    static class Solution {
        public int countComponents(int n, int[][] edges) {
            int count = n;
            int[] root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
            for (int i = 0; i < edges.length; i++) {
                int x = edges[i][0];
                int y = edges[i][1];
                int xRoot = getRoot(root, x);
                int yRoot = getRoot(root, y);
                if (xRoot != yRoot) {
                    count--;
                    root[xRoot] = yRoot;
                }
            }
            return count;
        }

        private int getRoot(int[] root, int i) {
            while (root[i] != i) {
                root[i] = root[root[i]];
                i = root[i];
            }
            return i;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] edges = new int[][] { { 0, 1 }, { 1, 2 }, { 3, 4 } };
        System.out.println(s.countComponents(5, edges));
    }
}
