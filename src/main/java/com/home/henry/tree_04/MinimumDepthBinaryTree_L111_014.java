package com.home.henry.tree_04;

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
}
