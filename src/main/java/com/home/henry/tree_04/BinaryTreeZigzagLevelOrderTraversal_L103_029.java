package com.home.henry.tree_04;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * BFS
 */
public class BinaryTreeZigzagLevelOrderTraversal_L103_029 {

    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            // corner case
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {return res;}
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            boolean flag = false; // if I need reverse the order
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> curr = new ArrayList<>();
                // initialize
                for (int i = 0; i < size; i++) {
                    curr.add(0);
                }
                for (int i = 0; i < size; i++) {
                    TreeNode tmp = queue.poll();
                    if (flag) {
                        curr.set(size - 1 - i, tmp.val);
                    } else {
                        curr.set(i, tmp.val);
                    }
                    if (tmp.left != null) {
                        queue.offer(tmp.left);
                    }
                    if (tmp.right != null) {
                        queue.offer(tmp.right);
                    }
                }
                res.add(curr);
                flag = !flag;
            }
            return res;
        }
    }

    // dfs recursive
    static class SolutionDFS {
        public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            helper(res, root, 0);
            return res;
        }

        private static void helper(List<List<Integer>> res, TreeNode root, int level) {
            if (root == null) {return;}
            if (level > res.size()) {
                res.add(new ArrayList<>());
                if (level % 2 == 1) {
                    res.get(level).add(0, root.val);
                } else {
                    res.get(level).add(root.val);
                }
                helper(res, root.left, level + 1);
                helper(res, root.right, level + 1);
            }
        }
    }

}
