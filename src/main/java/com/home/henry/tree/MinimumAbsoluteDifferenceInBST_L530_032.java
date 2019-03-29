package com.home.henry.tree;

/**
 * 530. Minimum Absolute Difference in BST
 *
 * Since this is a BST, the inorder traversal of its nodes results in a sorted list of values. Thus, the minimum
 * absolute difference must occur in any adjacently traversed nodes. I use the global variable "prev" to
 * keep track of each node's inorder predecessor.
 */
public class MinimumAbsoluteDifferenceInBST_L530_032 {

    private int minDiff = Integer.MAX_VALUE;

    private TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {return;}
        inOrder(root.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, root.val - prev.val);
        }
        prev = root;
        inOrder(root.right);
    }
}
