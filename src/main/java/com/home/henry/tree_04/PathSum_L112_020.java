package com.home.henry.tree_04;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 */
public class PathSum_L112_020 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {return false;}
        if (root.left == null && root.right == null) {
            if (root.val == sum) {return true;}
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
