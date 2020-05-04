package com.home.henry.tree_04;

/**
 * 250. Count Univalue Subtrees
 *
 * Given a binary tree, write a program to count the number of Single Valued Subtrees.
 * A Single Valued Subtree is one in which all the nodes have same value. Expected time complexity is O(n).
 *
 * Input: root of below tree
 *               5
 *              / \
 *             1   5
 *            / \   \
 *           5   5   5
 * Output: 4
 * There are 4 subtrees with single values.
 *
 * Input: root of below tree
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * Output: 5
 * There are five subtrees with single values.
 *
 * post order的方法
 */
public class CountUnivalueSubtrees_L250_026 {
    static class Solution {
        private static int res;

        public static int count(TreeNode root) {
            res = 0;
            if (root == null) {return res;}
            helper(root);
            return res;
        }

        public static boolean helper(TreeNode root) {
            if (root == null) {return true;}
            boolean left = helper(root.left);
            boolean right = helper(root.right);
            if (left && right) {
                if (root.left != null && root.val != root.left.val) {
                    return false;
                }
                if (root.right != null && root.val != root.right.val) {
                    return false;
                }
            }
            res++;
            return true;
        }
    }
}
