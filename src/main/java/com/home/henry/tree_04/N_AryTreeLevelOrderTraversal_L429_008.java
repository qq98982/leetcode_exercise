package com.home.henry.tree_04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N-ary Tree Level Order Traversal
 *
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is
 * separated by the null value (See examples).
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 *
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 *
 * BFS方法, 或者recursive
 */
public class N_AryTreeLevelOrderTraversal_L429_008 {

    static class SolutionBFS {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null) {
                return res;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> currLevel = new LinkedList<>();
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    Node curr = queue.poll();
                    currLevel.add(curr.val);
                    for (Node c : curr.children) {
                        queue.offer(c);
                    }
                }
                res.add(currLevel);
            }
            return res;
        }
    }

    static class SolutionRescursive {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {return res;}
            helper(res, root, 0);
            return res;
        }

        private void helper(List<List<Integer>> res, Node root, int level) {
            if (root == null) {return;}
            if (level == res.size()) {res.add(new ArrayList<>());}
            res.get(level).add(root.val);
            if (root.children == null) {return;}
            for (Node n : root.children) {
                helper(res, n, level + 1);
            }
        }
    }

}
