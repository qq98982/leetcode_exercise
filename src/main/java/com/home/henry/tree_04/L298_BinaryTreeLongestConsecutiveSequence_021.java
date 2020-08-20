package com.home.henry.tree_04;

/**
 * 	298. Binary Tree Longest Consecutive Sequence
 *
 * 	Given a Binary Tree find the length of the longest path which comprises of nodes with consecutive values in
 * 	increasing order. Every node is considered as a path of length 1.
 */
public class L298_BinaryTreeLongestConsecutiveSequence_021 {
    static class Solution {
        public static int binaryTreeLongestConsecutiveSequence(TreeNode root) {
            return helper(root, 1, root.val + 1, 1);
        }

        private static int helper(TreeNode root, int curr, int expect, int res) {
            if (root == null) {return res;}
            if (root.val != expect) {
                curr = 1;
            }
            res = Math.max(curr, res);
            return Math.max(helper(root.left, curr + 1, root.val + 1, res),
                            helper(root.right, curr + 1, root.val + 1, res));
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left = new TreeNode(7);
        System.out.println("3 -> " + Solution.binaryTreeLongestConsecutiveSequence(root));
        System.out.println("1 -> " + Solution.binaryTreeLongestConsecutiveSequence(new TreeNode(1)));
        TreeNode r2 = new TreeNode(6);
        r2.right = new TreeNode(9);
        r2.right.left = new TreeNode(7);
        r2.right.right = new TreeNode(10);
        r2.right.right.right = new TreeNode(11);
        System.out.println("3 -> " + Solution.binaryTreeLongestConsecutiveSequence(r2));
    }
}
