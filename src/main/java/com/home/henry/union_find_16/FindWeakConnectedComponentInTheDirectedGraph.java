package com.home.henry.union_find_16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Find the Weak Connected Component in the Directed Graph
 * 这个比323的单纯求size要难度大点, 用map版本的Union find比较合适
 * lintcode题目序号432
 */
public class FindWeakConnectedComponentInTheDirectedGraph {
    static class Solution {

        static class DirectedGraphNode {
            int label;
            ArrayList<DirectedGraphNode> neighbors;

            DirectedGraphNode(int x) {
                label = x;
                neighbors = new ArrayList<>();
            }
        }

        static private class MapUnionFind {
            Map<Integer, Integer> map = new HashMap<>();

            // 在这个题目中初始化union find用的是list做为参数
            MapUnionFind(List<Integer> set) {
                for (Integer i : set) {
                    map.put(i, i);
                }
            }

            int find(int p) {
                int root = map.get(p);
                while (root != map.get(root)) {
                    root = map.get(root);
                }
                int fa = p;
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

        public List<List<Integer>> connectedSet(List<DirectedGraphNode> nodes) {
            List<Integer> array = new ArrayList<>();
            // 添加所有的结点值, 包括neighbor到set中
            for (DirectedGraphNode node : nodes) {
                if (!array.contains(node.label)) {
                    array.add(node.label);
                }
                for (DirectedGraphNode neighbor : node.neighbors) {
                    if (!array.contains(neighbor.label)) {
                        array.add(neighbor.label);
                    }
                }
            }
            // 将当前的结点和neighbors union起来
            // 用uf找到图中所有cc，路径压缩使每个cc中的所有点都有唯一parent
            MapUnionFind uf = new MapUnionFind(array);
            for (DirectedGraphNode now : nodes) {
                for (DirectedGraphNode neighbors : now.neighbors) {
                    uf.union(now.label, neighbors.label);
                }
            }
            List<List<Integer>> res = new ArrayList<>();
            // 再次遍历图中所有点，用一个HashSet记录图中找过的cc的代表元素。若某点所在cc还未被找过
            // 则寻找所有该cc中的点加入list，同时将该cc的代表元素加入HashSet
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nodes.size(); i++) {
                // set中含有这个节点的root, continue
                int o = uf.find(nodes.get(i).label);
                if (set.contains(o)) {
                    continue;
                }
                set.add(o);
                List<Integer> list = new ArrayList<>();
                list.add(o);
                // 添加剩下所有的分支中的全部label, 如果和当前的节点的root相同, 加入到list中
                for (int j = i + 1; j < nodes.size(); j++) {
                    if (uf.find(nodes.get(j).label) == o) {
                        list.add(nodes.get(j).label);
                    }
                }
                res.add(list);
            }
            return res;
        }
    }
}
