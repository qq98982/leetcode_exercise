package com.home.henry.tree_04;

/**
 * 543. Diameter of Binary Tree
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary
 * tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 */
public class DiameterOfBinaryTree_L543_024 {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {return 0;}
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
