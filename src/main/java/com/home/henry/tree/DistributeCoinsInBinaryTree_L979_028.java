package com.home.henry.tree;

/**
 * 979. Distribute Coins in Binary Tree
 * First method, Write a dfs helper, return the number of coins given to the parent.
 * Second method using recursive way.
 */
public class DistributeCoinsInBinaryTree_L979_028 {
    private int res;

    public int distributeCoins(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left), right = helper(root.right);
        res += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }

    public int distributeCoinsSec(TreeNode root) {
        int res = 0;
        if (root.left != null) {
            res += distributeCoinsSec(root.left);
            root.val += root.left.val - 1;
            res += Math.abs(root.left.val - 1);
        }
        if (root.right != null) {
            res += distributeCoinsSec(root.right);
            root.val += root.right.val - 1;
            res += Math.abs(root.right.val - 1);
        }
        return res;
    }
}
