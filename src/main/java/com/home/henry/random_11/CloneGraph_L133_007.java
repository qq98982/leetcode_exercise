package com.home.henry.random_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 133. Clone Graph
 */
public class CloneGraph_L133_007 {

    static class Solution {
        public Node cloneGraph(Node node) {
            return helper(node, new HashMap<>());
        }

        private Node helper(Node node, Map<Node, Node> store) {
            if (node == null) {
                return null;
            }
            if (store.containsKey(node)) {
                return store.get(node);
            }
            Node clone = new Node();
            clone.val = node.val;
            store.put(node, clone);
            if (node.neighbors == null) {
                return clone;
            }
            List<Node> neighbors = new ArrayList<>();
            for (Node neigh : node.neighbors) {
                neighbors.add(helper(neigh, store));
            }
            clone.neighbors = neighbors;
            return clone;
        }

        private static class Node {
            public int val;
            public List<Node> neighbors;

            public Node() {}

            public Node(int val) {this.val = val;}

            public Node(int _val, List<Node> _neighbors) {
                val = _val;
                neighbors = _neighbors;
            }
        }
    }
}
