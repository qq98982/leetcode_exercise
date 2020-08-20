package com.home.henry.tree_04;

/**
 * 979. Distribute Coins in Binary Tree
 *
 * Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.
 * In one move, we may choose two adjacent nodes and move one coin from one node to another.
 * (The move may be from parent to child, or from child to parent.)
 * Return the number of moves required to make every node have exactly one coin.
 *
 * Input: [3,0,0] Output: 2
 * Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.
 *
 * Input: [0,3,0]
 * Output: 3
 * Explanation: From the left child of the root, we move two coins to the root [taking two moves].
 * Then, we move one coin from the root of the tree to the right child.
 *
 * Input: [1,0,2]
 * Output: 2
 *
 * Input: [1,0,0,null,3]
 * Output: 4
 *
 * First method, Write a dfs helper, return the number of coins given to the parent.
 * Second method using recursive way.
 */
public class L979_DistributeCoinsInBinaryTree_028 {
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
