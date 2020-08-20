package com.home.henry.tree_04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. Average of Levels in Binary Tree
 *
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 *
 * 推荐使用bfs, 使用dfs要额外记录sum和size
 */
public class L637_AverageOfLevelsInBinaryTree_036 {
    static class Solution {
        public static List<Double> averageOfLevels(TreeNode root) {
            List<Double> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if (root == null) { return result; }
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                double sum = 0.0;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    if (node.left != null) { queue.offer(node.left); }
                    if (node.right != null) { queue.offer(node.right); }
                }
                result.add(sum / size);
            }
            return result;
        }

    }

    public static class SolutionDFS {
        class Node {
            double sum;
            int count;

            Node(double d, int c) {
                sum = d;
                count = c;
            }
        }

        public List<Double> averageOfLevels(TreeNode root) {
            List<Node> temp = new ArrayList<>();
            helper(root, temp, 0);
            List<Double> result = new LinkedList<>();
            for (int i = 0; i < temp.size(); i++) {
                result.add(temp.get(i).sum / temp.get(i).count);
            }
            return result;
        }

        public void helper(TreeNode root, List<Node> temp, int level) {
            if (root == null) { return; }
            if (level == temp.size()) {
                Node node = new Node((double) root.val, 1);
                temp.add(node);
            } else {
                temp.get(level).sum += root.val;
                temp.get(level).count++;
            }
            helper(root.left, temp, level + 1);
            helper(root.right, temp, level + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("[3, 14.5, 11] -> " + Solution.averageOfLevels(root));
    }
}
