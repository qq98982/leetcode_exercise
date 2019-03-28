package com.home.henry.tree;

public class UnivaluedBinaryTree_L965_016 {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {return true;}
        return (root.left == null || root.left.val == root.val && isUnivalTree(root.left)) && (
                root.right == null ||
                root.right.val
                == root.val
                && isUnivalTree(
                        root.right));
    }

}
