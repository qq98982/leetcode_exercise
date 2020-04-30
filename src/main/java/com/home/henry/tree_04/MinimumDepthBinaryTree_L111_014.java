package com.home.henry.tree_04;

/**
 * 111. Minimum Depth of Binary Tree
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 */
public class MinimumDepthBinaryTree_L111_014 {

    public int minDepth(TreeNode root) {
        if (root == null) {return 0;}
        if (root.left == null && root.right == null) { return 1;}
        if (root.left == null) {return minDepth(root.right) + 1;}
        if (root.right == null) {return minDepth(root.left) + 1;}
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left, right) + 1;
    }

    public int minDepthClean(TreeNode root) {
        if (root == null) {return 0;}
        if (root.left == null || root.right == null) {
            return Math.max(minDepthClean(root.left), minDepthClean(root.right)) + 1;
        }
        return Math.min(minDepthClean(root.left), minDepthClean(root.right)) + 1;
    }
}
