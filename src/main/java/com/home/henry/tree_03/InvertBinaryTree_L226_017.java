package com.home.henry.tree_03;

public class InvertBinaryTree_L226_017 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) { return root;}
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
