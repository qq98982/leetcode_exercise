package com.home.henry.tree;

/**
 * 687. Longest Univalue Path
 * Given a binary tree, find the length of the longest path where each node in the path has the same value.
 * This path may or may not pass through the root.
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class LongestUnivaluePath_L687_025 {

    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {return 0;}
        int left = helper(root.left);
        int right = helper(root.right);

        left = root.left != null && root.left.val == root.val ? left + 1 : 0;
        right = root.right != null && root.right.val == root.val ? right + 1 : 0;
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }

}
