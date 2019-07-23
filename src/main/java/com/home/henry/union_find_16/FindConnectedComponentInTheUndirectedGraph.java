package com.home.henry.union_find_16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Find the Connected Component in the Undirected Graph
 * 这个比323的单纯求size要难度大点, 用map版本的Union find比较合适
 */
public class FindConnectedComponentInTheUndirectedGraph {
    static class Solution {

        static class UndirectedGraphNode {
            int label;
            ArrayList<UndirectedGraphNode> neighbors;

            UndirectedGraphNode(int x) {
                label = x;
                neighbors = new ArrayList<UndirectedGraphNode>();
            }
        }

        static private class MapUnionFind {
            Map<Integer, Integer> map = new HashMap<>();

            // 在这个题目中初始化union find用的是set做为参数
            MapUnionFind(Set<Integer> set) {
                for (Integer i : set) {
                    map.put(i, i);
                }
            }

            int find(int p) {
                int root = map.get(p);
                while (root != map.get(root)) {
                    root = map.get(root);
                }
                int fa = map.get(p);
                while (fa != map.get(fa)) {
                    int temp = map.get(fa);
                    map.put(fa, root);
                    fa = temp;
                }
                return root;
            }

            void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP != rootQ) {
                    map.put(rootP, rootQ);
                }
            }
        }

        public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
            Set<Integer> set = new HashSet<>();
            // 添加所有的结点值, 包括neighbor到set中
            for (UndirectedGraphNode node : nodes) {
                set.add(node.label);
                for (UndirectedGraphNode neighbor : node.neighbors) {
                    set.add(neighbor.label);
                }
            }
            // 将当前的结点和neighbors union起来
            MapUnionFind uf = new MapUnionFind(set);
            for (UndirectedGraphNode now : nodes) {
                for (UndirectedGraphNode neighbors : now.neighbors) {
                    uf.union(now.label, neighbors.label);
                }
            }
            List<List<Integer>> res = new ArrayList<>();
            Map<Integer, List<Integer>> map = new HashMap<>();
            // Map, 以uf中的根结点为为key, list为value, 如果属于某个key, 加入到这个list中, 如果没有, 新建立一个list再放
            for (int i : set) {
                int fa = uf.find(i);
                if (!map.containsKey(fa)) {
                    map.put(fa, new ArrayList<>());
                }
                List<Integer> now = map.get(fa);
                now.add(i);
                map.put(fa, now);
            }
            // 将value取出来, 并进行sort, 每一个value就是一个要的list, 加入到最终返回结果中
            for (List<Integer> now : map.values()) {
                Collections.sort(now);
                res.add(now);
            }
            return res;
        }
    }
}
